package it.nepsthermoney.repository;

import it.nepsthermoney.entity.Category;
import it.nepsthermoney.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
