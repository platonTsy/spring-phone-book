package com.phonebook.repository;

import com.phonebook.domain.Phone;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaPhoneRepository implements TagRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Phone> findAll() {
        return this.entityManager.createQuery("SELECT ph FROM Phone ph", Phone.class)
                .getResultList();
    }

}