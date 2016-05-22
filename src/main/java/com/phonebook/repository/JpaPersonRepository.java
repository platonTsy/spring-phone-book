package com.phonebook.repository;

import com.phonebook.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaPersonRepository implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findAll() {
        return this.entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

}