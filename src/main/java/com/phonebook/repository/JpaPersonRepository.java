package com.phonebook.repository;

import com.phonebook.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaPersonRepository implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Person create(Person person) {
        List<Person> personResult = entityManager
                .createQuery("SELECT p FROM Person p WHERE p.firstName=:fn AND p.lastName=:ln", Person.class)
                .setParameter("fn", person.getFirstName())
                .setParameter("ln", person.getLastName())
                .getResultList();
        if(personResult.size() > 0){
            return null;
        }
        entityManager.persist(person);
        return person;
    }

}