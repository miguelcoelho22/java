package com.example.email_service.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.example.email_service.adapters.EmailSenderGateway;
import com.example.email_service.core.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
     public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest().
                withSource("miguelarthurmeumine@gmail.com").
                withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message().withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try{
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonServiceException e){
            throw new EmailServiceException("failure while sending email", e);
        }


    }
}