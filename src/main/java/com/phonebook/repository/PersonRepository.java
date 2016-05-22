package com.phonebook.repository;

import com.phonebook.domain.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findAll();

}