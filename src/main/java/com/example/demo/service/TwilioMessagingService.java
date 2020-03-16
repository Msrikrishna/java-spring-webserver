package com.example.demo.service;

import com.example.demo.entity.MyMessageEntity;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.MDC;


@Service
public class TwilioMessagingService {
    final static Logger logger = LoggerFactory.getLogger(TwilioMessagingService.class);

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String FROM_PHONE_NUMBER = "+14242861053";

    //No purpose here. A simple demo of Async usage- This starts process in a new thread.
    //For my use case however, I must use DeferredResult a callback to set a URL to return the status 
    //of the execution at a later time
    @Async("asyncExecutor")
    public CompletableFuture<String> sendSMSWithTwilio(MyMessageEntity messageEntity) throws InterruptedException {
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      Message message = Message.creator(new PhoneNumber(messageEntity.getToPhoneNumber()),
          new PhoneNumber(FROM_PHONE_NUMBER), 
          messageEntity.getMessageText()).create();
        
     // System.out.println(message.getStatus()+message.getPrice()+message.getErrorCode()+message.getFrom());
      return CompletableFuture.completedFuture(message.getStatus().toString());
    
}





}