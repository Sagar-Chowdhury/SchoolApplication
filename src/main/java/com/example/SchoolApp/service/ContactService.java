package com.example.SchoolApp.service;

import com.example.SchoolApp.model.Contact;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.logging.Logger;

@Slf4j
@Service
@RequestScope
@Data
public class ContactService {

   private int counter=0;

   public ContactService(){
       System.out.println("Contact Service Bean Initialized");
   }

   public boolean saveMessageDetails(Contact contact)
   {
       boolean isSaved=true;
       // Need to persist data on DB
       log.info(contact.toString());
       return isSaved;
   }

}
