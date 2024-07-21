package com.sendNotification.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
	
	private String mailFrom;
	private String mailTo;
	private String mailSubject;
	private String mailBody;
    private String contentType = "text/plain";
    private String mailContent;
//    private List <Object> attachments;

}
