package com.example.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.example.demo.entity.MyMessageEntity;
import com.example.demo.service.TwilioMessagingService;
import com.twilio.rest.api.v2010.account.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * TwilioSMSController
 */

@RestController
@RequestMapping("/sendSMS")
public class TwilioSMSController {

    final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private TwilioMessagingService twilioMessagingService;

    @CrossOrigin
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, value = "/create")
    public String sendSMS(@RequestBody MyMessageEntity message) {

        
        //  ModelAndView mav = new ModelAndView("hello");  //Retrieves hello.html from templates
        try {
            CompletableFuture<String> messageString = twilioMessagingService.sendSMSWithTwilio(message);
            
            String resultString = messageString.get(10, TimeUnit.SECONDS);
            //If it takes more than 10 sec to execute sendSMSWithTwilio, it throws a error
            return resultString;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error("Can't send a message ", e);
            e.printStackTrace();
        }

        return null;
    }




    
}