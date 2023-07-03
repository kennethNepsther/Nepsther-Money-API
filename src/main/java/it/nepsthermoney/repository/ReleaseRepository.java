package it.nepsthermoney.repository;

import it.nepsthermoney.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release,Long>, ReleaseRepositoryQuery {
}
