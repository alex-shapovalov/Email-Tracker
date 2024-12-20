package com.em.Email_Tracker.controller;

import com.em.Email_Tracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class TrackingController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/track")
    public ResponseEntity<Void> trackEmail(@RequestParam("email") String email, HttpServletRequest request) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email parameter is missing or invalid.");
        }

        String userAgent = request.getHeader("User-Agent");
        String ipAddress = request.getRemoteAddr();
        LocalDateTime timestamp = LocalDateTime.now();

        emailService.sendReadReceipt(email, userAgent, ipAddress, timestamp);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "https://emperor.llc");
        return ResponseEntity.status(302).headers(headers).build();
    }
}