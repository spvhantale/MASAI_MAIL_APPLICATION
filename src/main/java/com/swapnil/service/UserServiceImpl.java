package com.swapnil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnil.exception.EmailException;
import com.swapnil.exception.UserException;
import com.swapnil.model.Email;
import com.swapnil.model.User;
import com.swapnil.repository.EmailDAO;
import com.swapnil.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private EmailDAO eDao;
	
	@Autowired
	private UserDAO uDao;
	
	@Override
	public User registerUser(User user) throws UserException{
	
		Optional<User> u=uDao.findById(user.getEmail());
		
		if(u.isPresent()) {
			throw new UserException("User with this mail already present");
		}else {
			User ue=uDao.save(user);

			return ue;
		}
		
	}

	@Override
	public User updateUser(User user) throws UserException {

		Optional<User> u=uDao.findById(user.getEmail());
		
		if(u.isPresent()) {
			User ue=uDao.save(user);

			return ue;
			
		}else {
			throw new UserException("User with this mail already present");
		}
		
	}

	@Override
	public List<Email> getAllMail(Integer userId) throws EmailException, UserException {
		
		User u=uDao.findByUserId(userId);
		
		if(u==null) {
			throw new UserException("Use not found");
		}else {
			List<Email> elist=u.getReciveMail();
			return elist;
		}
	}

	@Override
	public List<Email> getAllstar(Integer userId) throws UserException, EmailException {
	
			User u=uDao.findByUserId(userId);
		
		if(u==null) {
			throw new UserException("Use not found");
		}else {
			List<Email> elist=u.getReciveMail();
			List<Email> liststar=new ArrayList<>();
			for(Email e:elist) {
				if(e.getStar()==true) {
					liststar.add(e);
				}
			}
			return liststar;
		}
	}

}
