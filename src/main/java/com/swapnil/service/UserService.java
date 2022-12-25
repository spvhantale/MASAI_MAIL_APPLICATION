package com.swapnil.service;

import java.util.List;

import com.swapnil.exception.EmailException;
import com.swapnil.exception.UserException;
import com.swapnil.model.Email;
import com.swapnil.model.User;

public interface UserService {

	
	public User registerUser(User user)throws UserException;
	public User updateUser(User user) throws UserException;
	
	public List<Email> getAllMail(Integer userId) throws EmailException,UserException;
	
	public List<Email> getAllstar(Integer userId) throws UserException,EmailException;
	
	
}
