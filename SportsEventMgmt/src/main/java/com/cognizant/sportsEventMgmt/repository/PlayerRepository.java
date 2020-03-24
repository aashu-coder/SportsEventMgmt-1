package com.cognizant.sportsEventMgmt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.sportsEventMgmt.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Transactional
	@Modifying
	@Query("update  Player p set  emailId=?1 ,contactNumber=?2 ,age=?3,gender=?4 where pId=?5")
	void updatePlayer(String emailId, String contactNumber, String age, String gender, int pId);

}