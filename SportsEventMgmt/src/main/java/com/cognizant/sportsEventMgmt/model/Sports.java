package com.cognizant.sportsEventMgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Sports {

	// OSports Name, Sports Type, No of players, Time of Match
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;

	@NotEmpty(message = "*Sports name is mandatory")
	@Pattern(regexp = "[A-z|\\s]+", message = "*Sports name should be alphabet only")
	@Size(min = 1, max = 30, message = "*Sports name should have atleast min 1 and max 30 chars")
	private String sportsName;

	@NotEmpty(message = "*Please select sports type")
	private String sportsType;

	@NotEmpty(message = "*Numbers of players is mandatory")
	@Pattern(regexp = "([0-1]?[0-9]|20)", message = "*Number of players should be between 1 to 20")
	private String noOfPlayers;

	@NotEmpty(message = "*Time is mandatory")
	@Pattern(regexp = "([0-1]?[0-9]|2[0-3]):[0-5][0-9]", message = "*Time should be in HH:MM format")
	private String timeOfMatch;

	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sports(int sId,
			@NotEmpty(message = "*Sports name is mandatory") @Pattern(regexp = "[A-z|\\s]+", message = "*Sports name should be alphabet only") @Size(min = 1, max = 30, message = "*[Sports name should have atleast min 1 and max 30 chars") String sportsName,
			@NotEmpty(message = "*Please select sports type") String sportsType,
			@NotEmpty(message = "*Numbers of players is mandatory") @Pattern(regexp = "([0-1]?[0-9]|20)", message = "Number of players should be between 1 to 20") String noOfPlayers,
			@NotEmpty(message = "*Time is mandatory") @Pattern(regexp = "([0-1]?[0-9]|2[0-3]):[0-5][0-9]", message = "Time should be in HH:MM format") String timeOfMatch) {
		super();
		this.sId = sId;
		this.sportsName = sportsName;
		this.sportsType = sportsType;
		this.noOfPlayers = noOfPlayers;
		this.timeOfMatch = timeOfMatch;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getSportsType() {
		return sportsType;
	}

	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}

	public String getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(String noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getTimeOfMatch() {
		return timeOfMatch;
	}

	public void setTimeOfMatch(String timeOfMatch) {
		this.timeOfMatch = timeOfMatch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noOfPlayers == null) ? 0 : noOfPlayers.hashCode());
		result = prime * result + sId;
		result = prime * result + ((sportsName == null) ? 0 : sportsName.hashCode());
		result = prime * result + ((sportsType == null) ? 0 : sportsType.hashCode());
		result = prime * result + ((timeOfMatch == null) ? 0 : timeOfMatch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sports other = (Sports) obj;
		if (noOfPlayers == null) {
			if (other.noOfPlayers != null)
				return false;
		} else if (!noOfPlayers.equals(other.noOfPlayers))
			return false;
		if (sId != other.sId)
			return false;
		if (sportsName == null) {
			if (other.sportsName != null)
				return false;
		} else if (!sportsName.equals(other.sportsName))
			return false;
		if (sportsType == null) {
			if (other.sportsType != null)
				return false;
		} else if (!sportsType.equals(other.sportsType))
			return false;
		if (timeOfMatch == null) {
			if (other.timeOfMatch != null)
				return false;
		} else if (!timeOfMatch.equals(other.timeOfMatch))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sports [sId=" + sId + ", sportsName=" + sportsName + ", sportsType=" + sportsType + ", noOfPlayers="
				+ noOfPlayers + ", timeOfMatch=" + timeOfMatch + "]";
	}

}
