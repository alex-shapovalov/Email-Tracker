package com.em.Email_Tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String username;

    // Modify this to suit your needs
    String recipient = "contact@emperor.llc";

    @Autowired
    private JavaMailSender mailSender;

    public void sendReadReceipt(String recipientEmail, String userAgent, String ipAddress, LocalDateTime timestamp) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(recipient);
        message.setSubject("Email Read Notification");
        message.setText(String.format(
                "The email sent to %s was read at %s.\nUser Agent: %s\nIP Address: %s",
                recipientEmail, timestamp, userAgent, ipAddress
        ));

        mailSender.send(message);
    }
}