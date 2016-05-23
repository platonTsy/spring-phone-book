package com.phonebook.repository;

import com.phonebook.domain.Phone;

import java.util.List;

public interface PhoneRepository {

    List<Phone> findAll();

}