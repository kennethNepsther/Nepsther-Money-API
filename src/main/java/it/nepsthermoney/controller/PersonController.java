package it.nepsthermoney.controller;

import it.nepsthermoney.entity.Person;
import it.nepsthermoney.entity.dto.request.PersonDto;
import it.nepsthermoney.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static it.nepsthermoney.util.UriUtil.addIdToCurrentUrlPath;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/person")
public class PersonController {
    PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = personService.findById(id);
        return ResponseEntity.ok((person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> person = personService.findAll();
        return ResponseEntity.ok().body(person);

    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody PersonDto personDto){
        var person = new Person();
        BeanUtils.copyProperties(personDto, person);
        person =  personService.save(person);
        return ResponseEntity.created( addIdToCurrentUrlPath(person.getId())).body(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id,@Valid @RequestBody PersonDto personDto){
        var person = new Person();
        BeanUtils.copyProperties(personDto, person);
         person = personService.update(id, person);
        return ResponseEntity.ok().body(person);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Person> updatePersonStatus(@PathVariable Long id,@Valid @RequestBody Boolean active){
       personService.updatePersonStatus(id, active);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted");
}
}