package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
    public String getContentsFromHelper(String pageName)
    {
       
       
       
       List<Page> pages = subject.queryContent(anonUser, Collections.singletonList(pageName));

       Page page = pages.get(0);

       return page.getCurrentContent();
    }

    
    public String getContentDirectlyFromWiki(String pageName)
    {

        String url = "https://www.mediawiki.org/w/api.php?action=query&prop=revisions&meta=siteinfo&titles="+pageName+"&rvprop=user%7Ccomment&continue=";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        String response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        } catch (RestClientException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
       
        return response.toString();  
    }
    
}