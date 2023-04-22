package it.nepsthermoney.service;


import it.nepsthermoney.entity.Person;

import java.util.List;

public interface PersonService {

    Person findById(Long id);

    List<Person> findAll();

    Person save(Person person);

    Person update(Long id, Person person);

    void delete(Long id);
}
