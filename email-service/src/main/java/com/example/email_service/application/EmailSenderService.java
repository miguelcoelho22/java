package com.example.email_service.application;

import com.example.email_service.adapters.EmailSenderGateway;
import com.example.email_service.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
        emailSenderGateway.sendEmail(to, subject, body);
    }
}
