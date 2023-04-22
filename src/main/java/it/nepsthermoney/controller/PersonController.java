package it.nepsthermoney.controller;

import it.nepsthermoney.entity.Person;
import it.nepsthermoney.entity.dto.request.PersonDto;
import it.nepsthermoney.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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
}
