package com.phonebook.web;

import com.phonebook.domain.Person;
import com.phonebook.domain.Phone;
import com.phonebook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Controller
public class PhoneBookController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index", "allPersons", personRepository.findAll());
    }

    @RequestMapping(value = "add", params = {"save"})
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "add";
        }
        person.getPhones().stream().forEach(phone -> phone.setPerson(person));
        Person personSaved = personRepository.create(person);
        if(personSaved != null) {
            return "redirect:/";
        }
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddPersonView(Person person){
        person.setPhones(Arrays.asList(new Phone()));return "/add";
    }

    @RequestMapping(value="add", params={"addRow"})
    public String addRow(final Person person, final BindingResult bindingResult) {
        person.getPhones().add(new Phone());
        return "add";
    }


    @RequestMapping(value="/add", params={"removeRow"})
    public String removeRow(final Person person, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        person.getPhones().remove(rowId.intValue());
        return "add";
    }

}