package com.springdemo.demo;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class TwilioService {
    
    private final String accountSid;
    private final String authToken;
    private final String twilioPhoneNumber;
    
    public TwilioService(
            @Value("${twilio.account_sid}") String accountSid,
            @Value("${twilio.auth_token}") String authToken,
            @Value("${twilio.phone_number}") String twilioPhoneNumber) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.twilioPhoneNumber = twilioPhoneNumber;
    }
    
    @PostConstruct
    public void init() {
        Twilio.init(this.accountSid, this.authToken);
    }
    
    public void sendMessage(String to, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to),
                new PhoneNumber("whatsapp:" + twilioPhoneNumber),
                messageBody
        ).create();
        System.out.println("Message sent! SID: " + message.getSid());
    }
}