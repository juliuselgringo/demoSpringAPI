package fr.juliuselgringo.demospring.controller;

import fr.juliuselgringo.demospring.model.Person;
import fr.juliuselgringo.demospring.repository.PersonRepository;
import fr.juliuselgringo.demospring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> findAllPersons(){
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person findPersonById(@PathVariable("id") Integer id){
        Optional<Person> person = personService.getPerson(id);
        return person.orElse(null);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody Person person){
        Optional<Person> personOptional = personService.getPerson(id);
        if (personOptional.isPresent()) {
            Person person2Update = personOptional.get();

            String firstName = person.getFirstName();
            if(firstName != null){
                person2Update.setFirstName(firstName);
            }
            String  lastName = person.getLastName();
            if(lastName != null){
                person2Update.setLastName(lastName);
            }
            personService.savePerson(person2Update);
            return person2Update;
        }else{
            return null;
        }
    }

    @DeleteMapping("/person/{id}")
    public void deletePersonById(@PathVariable("id") Integer id){
        personService.deletePerson(id);
    }

}
