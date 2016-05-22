package com.phonebook.web;

import com.phonebook.domain.Person;
import com.phonebook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

@Controller
public class PhoneBookController {

    @Autowired
    private PersonRepository personRepository;

//    @RequestMapping("/")
//    @Transactional(readOnly = true)
//    public ModelAndView index() {
//        List<Person> persons = this.personRepository.findAll();
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("notes", persons);
//        return modelAndView;
//    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @ModelAttribute("allPersons")
    @Transactional(readOnly = true)
    public List<Person> populatePersons(){
        return personRepository.findAll();
    }

}