package com.em.Email_Tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReadReceipt(String recipientEmail, String userAgent, String ipAddress, LocalDateTime timestamp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@emperor.llc");
        message.setTo("contact@emperor.llc");
        message.setSubject("Email Read Notification");
        message.setText(String.format(
                "The email sent to %s was read at %s.\nUser Agent: %s\nIP Address: %s",
                recipientEmail, timestamp, userAgent, ipAddress
        ));

        mailSender.send(message);
    }
}