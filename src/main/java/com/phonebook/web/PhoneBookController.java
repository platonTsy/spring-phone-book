package com.phonebook.web;

import com.phonebook.domain.Person;
import com.phonebook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

@Controller
public class PhoneBookController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index", "allPersons", personRepository.findAll());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPerson(@ModelAttribute Person person) {
        Person personSaved = personRepository.create(person);
        if(personSaved != null) {
            home();
        }
        showAddView();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddView(){ return "add"; }

}