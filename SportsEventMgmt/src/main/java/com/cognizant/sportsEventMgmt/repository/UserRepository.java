package com.cognizant.sportsEventMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.sportsEventMgmt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where emailId=?1 and password=?2")
	User authenticateUser(String emailId, String password);
}