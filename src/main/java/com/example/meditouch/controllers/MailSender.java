package com.example.meditouch.controllers;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.example.meditouch.EmailService;

import java.util.Properties;

@Configuration
public class MailSender{

    @Bean
    public JavaMailSender javaMailSender() {
    	  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
          mailSender.setHost("smtp.gmail.com");
          mailSender.setPort(587);
          mailSender.setUsername("meditouch76@gmail.com");
          mailSender.setPassword("zjhbxjmunupbjili");
          Properties props = mailSender.getJavaMailProperties();
          props.put("mail.transport.protocol", "smtp");
          props.put("mail.smtp.auth", true);
          props.put("mail.smtp.starttls.enable", true);
          props.put("mail.debug", true);

          return mailSender;
    }

    @Bean
    public EmailService emailService() {
        return new EmailService(javaMailSender());
    }
}