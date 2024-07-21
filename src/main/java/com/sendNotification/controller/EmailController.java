package com.sendNotification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sendNotification.entity.Email;
import com.sendNotification.service.EmailService;

@RequestMapping("/sendMail")
@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendEmailNotification")
	public ResponseEntity<Object> sendEmailNotification(@RequestBody Email email) {
		String response = emailService.sendEmailNotification(email);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
