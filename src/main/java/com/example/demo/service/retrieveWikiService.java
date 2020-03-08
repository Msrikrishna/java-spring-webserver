package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import info.bliki.*;
import info.bliki.api.Connector;
import info.bliki.api.Page;
import info.bliki.api.TestUser;
import info.bliki.api.User;

/**
 * retrieveWikiService
 */

 @Service
public class retrieveWikiService {

    @Autowired
    RestTemplate restTemplate ;


    @Autowired
    private Connector subject;
    @Autowired
    private User anonUser;

    //Gets the contents of a wiki page using bliki helper/ parser lib and Wiki api
    public String getContents(String pageName)
    {
       // ResponseEntity<Entity> response = restTemplate.exchange(null, null, null, null, null);
       
       
       List<Page> pages = subject.queryContent(anonUser, Collections.singletonList(pageName));

       Page page = pages.get(0);

       return page.getCurrentContent();
    }
    
}