package fr.juliuselgringo.demospring.repository;

import fr.juliuselgringo.demospring.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    // pas de code, nous donne accés au CRUD
}
