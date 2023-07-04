package it.nepsthermoney.repository.impl;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.repository.ReleaseRepositoryQuery;
import it.nepsthermoney.repository.filter.ReleaseFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReleaseRepositoryImpl implements ReleaseRepositoryQuery {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Page<Release> filterRelease(ReleaseFilter releaseFilter, Pageable pageable) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Release> criteria = builder.createQuery(Release.class);
        Root<Release> root = criteria.from(Release.class);

        // create restrictions
        Predicate[] predicates = createRestrictions(releaseFilter,builder, root);
        criteria.where(predicates);


        TypedQuery<Release> query = entityManager.createQuery(criteria);
        paginationRestrictionsQuery(query,pageable);
        return new PageImpl<>(query.getResultList(),pageable, totalPages(releaseFilter)) ;
    }

    private Long totalPages(ReleaseFilter releaseFilter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Release> root = criteria.from(Release.class);

        Predicate[] predicates = createRestrictions(releaseFilter, builder,root);
        criteria.where(predicates);
        criteria.select(builder.count(root));
        return entityManager.createQuery(criteria).getSingleResult();
    }

    private void paginationRestrictionsQuery(TypedQuery<Release> query, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
        int totalElementToShowInPage = pageable.getPageSize();
        int firstElementToShowInPage =currentPage * totalElementToShowInPage;
        query.setFirstResult(firstElementToShowInPage);
        query.setMaxResults(totalElementToShowInPage);
    }

    private Predicate[] createRestrictions(ReleaseFilter releaseFilter, CriteriaBuilder builder, Root<Release> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (releaseFilter.getDescription()!=null){
           predicates.add(builder.like(
                    builder.lower(root.get("description")), "%" + releaseFilter.getDescription().toLowerCase() + "%"));
        }
        if (releaseFilter.getDueDateOf()!=null){
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get("dueDate"), releaseFilter.getDueDateOf()));
        }

        if (releaseFilter.getDueDateUntil()!=null){
            predicates.add(
                    builder.lessThanOrEqualTo(root.get("dueDate"), releaseFilter.getDueDateUntil()));
        }
        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
