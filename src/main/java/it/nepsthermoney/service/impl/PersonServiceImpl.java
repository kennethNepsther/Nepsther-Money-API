package it.nepsthermoney.service.impl;

import it.nepsthermoney.entity.Person;
import it.nepsthermoney.execptions.ObjectNotFoundException;
import it.nepsthermoney.repository.PersonRepository;
import it.nepsthermoney.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository;
    @Override
    public Person findById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return  person.orElseThrow(() -> new ObjectNotFoundException("No person  was found with this identifier " + id));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        person.setId(null);
        person.setName(person.getName());
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        Person personExist = findById(id);
        BeanUtils.copyProperties(person, personExist, "id");
        return personRepository.save(personExist);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        personRepository.deleteById(id);
    }
}
