package com.phonebook;

import com.phonebook.domain.Person;
import com.phonebook.domain.Phone;
import com.phonebook.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhoneBookApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@Transactional
public class JpaPersonRepositoryTests {

    @Autowired
    PersonRepository repository;

    @Test
    public void findAll() {

        List<Person> persons = this.repository.findAll();
        org.junit.Assert.assertEquals(7, persons.size());
        for (Person person : persons) {
            Assert.notEmpty(person.getPhones());
        }
    }

    @Test
    public void create(){
        Person newPerson = new Person("Petrov", "Petrovich");
        newPerson.setPhones(Arrays.asList(new Phone("0930934567", newPerson)));
        repository.create(newPerson);
        org.junit.Assert.assertEquals(8, repository.findAll().size());
        org.junit.Assert.assertEquals(8, newPerson.getIdPerson());
        Person newPerson2 = new Person("Petrov", "Petrovich");
        newPerson2.setPhones(Arrays.asList(new Phone("0943848493", newPerson2)));
        repository.create(newPerson2);
        org.junit.Assert.assertEquals(8, repository.findAll().size());
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void createFailureEmptyPhone(){
        Person newPerson = new Person("Petrov", "Petrovich");
        repository.create(newPerson);
    }

}