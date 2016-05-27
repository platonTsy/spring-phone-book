package com.phonebook.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone")
    private long idPhone;

    @Size(min = 10, max = 10, message = "{error.size.phone.number}")
    @Column(name = "phone_number")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private Person person;

    public Phone() {
    }

    public Phone(String number, Person person) {
        this.number = number;
        this.person = person;
    }

    public long getIdPhone() {
        return this.idPhone;
    }

    public void setIdPhone(long idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}