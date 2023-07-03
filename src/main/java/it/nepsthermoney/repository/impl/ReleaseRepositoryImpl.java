package it.nepsthermoney.repository.impl;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.repository.ReleaseRepositoryQuery;
import it.nepsthermoney.repository.filter.ReleaseFilter;

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
    public List<Release> filterRelease(ReleaseFilter releaseFilter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Release> criteria = builder.createQuery(Release.class);
        Root<Release> root = criteria.from(Release.class);

        // create restrictions
        Predicate[] predicates = createRestrictions(releaseFilter,builder, root);
        criteria.where(predicates);


        TypedQuery<Release> query = entityManager.createQuery(criteria);
        return query.getResultList();
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
