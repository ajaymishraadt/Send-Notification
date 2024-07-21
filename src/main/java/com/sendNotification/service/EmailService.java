package com.sendNotification.service;

import org.springframework.stereotype.Service;

import com.sendNotification.entity.Email;

@Service
public interface EmailService {

	public String sendEmailNotification(Email email);

}
