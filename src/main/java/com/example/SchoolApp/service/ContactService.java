package com.example.SchoolApp.service;

import com.example.SchoolApp.constants.SchoolConstants;
import com.example.SchoolApp.model.Contact;
import com.example.SchoolApp.repository.ContactRepository;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Slf4j
@Service
@RequestScope
@Data
public class ContactService {

   private int counter=0;

   @Autowired
   private ContactRepository contactRepository;
   public ContactService(){
       System.out.println("Contact Service Bean Initialized");
   }

   public boolean saveMessageDetails(Contact contact)
   {
       boolean isSaved=true;
       contact.setStatus(SchoolConstants.OPEN);
       contact.setCreatedBy(SchoolConstants.ANONYMOUS);
       contact.setCreatedAt(LocalDateTime.now());
       int result = contactRepository.saveContactMsg(contact);
       if(result>0){ isSaved=true; }
       return isSaved;
   }

}
