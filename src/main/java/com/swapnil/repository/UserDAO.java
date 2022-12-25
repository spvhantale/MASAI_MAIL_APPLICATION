package com.swapnil.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapnil.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

	public User findByUserId(Integer userId);
	public User findByMobileNumber(String mobileNumber);
}
