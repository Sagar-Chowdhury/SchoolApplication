package com.example.SchoolApp.service;

import com.example.SchoolApp.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Slf4j
@Service
public class ContactService {


   public boolean saveMessageDetails(Contact contact)
   {
       boolean isSaved=true;
       // Need to persist data on DB

       return isSaved;
   }

}
