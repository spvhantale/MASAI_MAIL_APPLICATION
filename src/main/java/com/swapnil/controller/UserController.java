package com.swapnil.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapnil.exception.EmailException;
import com.swapnil.exception.UserException;
import com.swapnil.model.Email;
import com.swapnil.model.User;
import com.swapnil.service.UserService;

@RestController
@RequestMapping("/masaimail")
public class UserController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException{
		
		User u=uService.registerUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws UserException{
		
		User u=uService.updateUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("/mail")
	public ResponseEntity<List<Email>> getAllMailUser(@PathVariable("userId") Integer userId) throws UserException, EmailException{
		
		List<Email> u=uService.getAllMail(userId);
		
		return new ResponseEntity<List<Email>>(u, HttpStatus.CREATED);
	}
	
	@PostMapping("/starred")
	public ResponseEntity<List<Email>> getAllStarMail(@PathVariable("userId") Integer userId) throws UserException, EmailException{
		
		List<Email> u=uService.getAllstar(userId);
		
		return new ResponseEntity<List<Email>>(u, HttpStatus.CREATED);
	}
	
	
	
	
}
