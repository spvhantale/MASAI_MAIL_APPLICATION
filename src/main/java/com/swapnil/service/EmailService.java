package com.swapnil.service;

import com.swapnil.dto.EmailDTO;
import com.swapnil.exception.EmailException;
import com.swapnil.exception.UserException;
import com.swapnil.model.Email;

public interface EmailService {

	
	public Email sendMail(EmailDTO emailDTO,Integer userId) throws EmailException,UserException;
	
	public Email starMail(Integer emailId,Integer userId) throws EmailException,UserException;

	public String deleteMail(Integer emailId,Integer userId) throws EmailException,UserException;
	
	
}
