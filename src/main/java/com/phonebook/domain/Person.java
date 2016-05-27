package com.phonebook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")

    private long idPerson;

    @Size(min = 1, max = 50)
    @Column(name = "firstname")
    private String firstName;

    @Size(min = 1, max = 50)
    @Column(name = "lastname")
    private String lastName;

    @Valid
    @NotEmpty
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Phone> phones = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public long getIdPerson() {
        return this.idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

}