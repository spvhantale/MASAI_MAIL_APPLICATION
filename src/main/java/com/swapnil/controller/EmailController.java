package com.swapnil.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapnil.dto.EmailDTO;
import com.swapnil.exception.EmailException;
import com.swapnil.exception.UserException;
import com.swapnil.model.Email;
import com.swapnil.repository.EmailDAO;
import com.swapnil.service.EmailService;

@RestController
@RequestMapping("/masaimail")
public class EmailController {

	@Autowired
	private EmailService eService;
	
	@PostMapping("/mail/{userId}")
	public ResponseEntity<Email> sendMail(@Valid @RequestBody EmailDTO mail,@PathVariable("userId") Integer userId) throws EmailException, UserException{
		
		Email e=eService.sendMail(mail, userId);
		
		return new ResponseEntity<Email>(e, HttpStatus.OK);
	}
	
	@PostMapping("/starred/{emailId}/{userId}")
	public ResponseEntity<Email> starMail(@PathVariable("emailId") Integer emailId,@PathVariable("userId") Integer userId) throws EmailException, UserException{
		
		Email e=eService.starMail(emailId, userId);
		
		return new ResponseEntity<Email>(e, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{emailId}/{userId}")
	public ResponseEntity<String> deleteMail(@PathVariable("emailId") Integer emailId,@PathVariable("userId") Integer userId) throws EmailException, UserException{
		
		String e=eService.deleteMail(emailId, userId);
		
		return new ResponseEntity<String>(e, HttpStatus.OK);
		
	}
}
