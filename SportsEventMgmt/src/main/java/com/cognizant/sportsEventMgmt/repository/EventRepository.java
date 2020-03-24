package com.cognizant.sportsEventMgmt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.sportsEventMgmt.model.Event;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Integer> {

	@Modifying
	@Query("update Event set  eventDate=?1 ,eventTime=?2 ,noOfSlots=?3 where eId=?4")
	void updatEvent(String eventDate, String eventTime, String noOfSlots, int eId);

}
