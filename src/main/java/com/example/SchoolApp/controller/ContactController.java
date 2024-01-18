package com.example.SchoolApp.controller;

import com.example.SchoolApp.model.Contact;
import com.example.SchoolApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(){
        return "contact.html";
    }

    @RequestMapping(value = "/saveMsg" , method = POST)
    public ModelAndView saveMessage(Contact contact)
    {
       contactService.saveMessageDetails(contact);
       System.out.println(contact.toString());
      return new ModelAndView("redirect:/contact");
    }





}
