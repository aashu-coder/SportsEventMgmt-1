package com.cognizant.sportsEventMgmt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.sportsEventMgmt.model.Sports;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Integer> {
	List<String> findName();

	@Transactional
	@Modifying
	@Query("update Sports set noOfPlayers =?1, timeOfMatch=?2 where sId =?3")
	void updateSports(String noOfPlayers, String timeOfMatch, int sId);

}
