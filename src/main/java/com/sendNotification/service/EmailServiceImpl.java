package com.sendNotification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sendNotification.entity.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	 @Override
	    public String sendEmailNotification(Email email) {
	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        try {
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setSubject(email.getMailSubject());
	            mimeMessageHelper.setFrom(email.getMailFrom());
	            mimeMessageHelper.setTo(email.getMailTo());
	            mimeMessageHelper.setText(email.getMailContent(), true); // Use true for HTML content
	            javaMailSender.send(mimeMessage);
	            return "Mail sent successfully";
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return "Failed to send mail";
	        }
	    }

//	@Override
//	public String sendEmailNotification(Email email) {
//		{
//			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//			try {
//				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//				mimeMessageHelper.setSubject(email.getMailSubject());
//				mimeMessageHelper.setFrom(new InternetAddress(email.getMailFrom()));
//				mimeMessageHelper.setTo(email.getMailTo());
//				mimeMessageHelper.setText(email.getMailContent());
//				javaMailSender.send(mimeMessageHelper.getMimeMessage());
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}
//			return "Mail send successfully";
//		}
//	}

}
