package com.example.demo.controller;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.*;
/**
 * ConsumeRESTcontroller
 */
@Controller
@RestController
@RequestMapping("/wiki")

//Uses Wiki service to get wiki related data
public class WikiController {
      
   final static Logger logger = LoggerFactory.getLogger(WikiController.class);

      @Autowired
      retrieveWikiService my_wiki_service;

      @GetMapping("/withhelper")
     public String getContentsController(@RequestParam(name = "page", defaultValue = "Java")   String query ){

         
         return my_wiki_service.getContentsFromHelper(query);
     }

     
     @GetMapping("/direct")
     public String getContentsDirectController(@RequestParam(name = "page", defaultValue = "Java")   String query ){

         
         return my_wiki_service.getContentDirectlyFromWiki(query);
     }

 
    
 
}