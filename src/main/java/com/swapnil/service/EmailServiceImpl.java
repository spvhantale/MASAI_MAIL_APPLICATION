package com.swapnil.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnil.dto.EmailDTO;
import com.swapnil.exception.EmailException;
import com.swapnil.exception.UserException;
import com.swapnil.model.Email;
import com.swapnil.model.User;
import com.swapnil.repository.EmailDAO;
import com.swapnil.repository.UserDAO;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private EmailDAO eDao;
	@Autowired
	private UserDAO uDao;

	@Override
	public Email sendMail(EmailDTO email,Integer userId) throws EmailException, UserException {
		
		User use=uDao.findByUserId(userId);
		if(use==null) {
			throw new UserException("User not found");
		}
		Email e=new Email();
		e.setBody(email.getBody());
		e.setEmail(use.getEmail());
		e.setLocalDateTime(LocalDateTime.now());
		e.setFromUser(use);
		List<String> slist=email.getSendTo();
		for(String st:slist) {
			Optional<User> u=uDao.findById(st);
			if(u.isPresent()) {
				e.getToUser().add(u.get());
				User us=u.get();
				us.getReciveMail().add(e);
				uDao.save(us);
			}
		}
		Email em=eDao.save(e);
		use.getSentMail().add(em);
		uDao.save(use);
		return em;
	}

	@Override
	public Email starMail(Integer emailId, Integer userId) throws EmailException, UserException {

		User u=uDao.findByUserId(userId);
		if(u==null) {
			throw new UserException("User not found");
		}else {
			List<Email> elist=u.getReciveMail();
			Optional<Email> ema=eDao.findById(emailId);
			if(ema.isPresent() && !elist.isEmpty()) {
				Email email=null;
			for(Email e:elist) {
				if(e.getEmailId()==ema.get().getEmailId()) {
					e.setStar(true);
					email=e;
					
				}	
			}
			User use=uDao.save(u);
			return email;
			}else {
				throw new EmailException("Email not found");
			}
		}
		
	}

	@Override
	public String deleteMail(Integer emailId, Integer userId) throws EmailException, UserException {
			
		User u=uDao.findByUserId(userId);
		if(u==null) {
			throw new UserException("User not found");
		}else {
			List<Email> elist=u.getReciveMail();
			
			Optional<Email> ema=eDao.findById(emailId);
			if(ema.isPresent()) {
				for(Email es:elist) {
					if(es.getEmailId()==ema.get().getEmailId()) {
						elist.remove(es);
					}
				}
				return "deleted";
			}else {
				throw new EmailException("email not found");
			}
		}
	
	}

}
