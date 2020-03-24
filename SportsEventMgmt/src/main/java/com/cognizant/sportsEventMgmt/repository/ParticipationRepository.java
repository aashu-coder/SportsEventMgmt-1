package com.cognizant.sportsEventMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.sportsEventMgmt.model.Participation;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {

}
