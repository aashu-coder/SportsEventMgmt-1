package com.cognizant.sportsEventMgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@NamedNativeQuery(name = "Sports.findName", query = "SELECT sports_name FROM sports")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eId;

	@NotEmpty(message = "*Please select sports name")
	private String sportsName;

	@NotEmpty(message = "*Event Name is mandatory")
	@Pattern(regexp = "[A-z|\\s]+", message = "*Event name should be alphabet only")
	private String eventName;

	@NotEmpty(message = "*Date is mandatory")
	@Pattern(regexp = "((0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-([12]\\d{3}))", message = "*Date should be in DD-MM-YYYY format")
	private String eventDate;

	@NotEmpty(message = "*Time is mandatory")
	@Pattern(regexp = "([0-1]?[0-9]|2[0-3]):[0-5][0-9]", message = "*Time should be in HH:MM format")
	private String eventTime;

	@NotEmpty(message = "*No Of Slots is mandatory")
	@Pattern(regexp = "[1-9]?[0-9]{1}$|^20", message = "*Slot should be in numbers only and less than 20")
	private String noOfSlots;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int eId, String sportsName, String eventName, String eventDate, String eventTime, String noOfSlots) {
		super();
		this.eId = eId;
		this.sportsName = sportsName;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.noOfSlots = noOfSlots;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(String noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	@Override
	public String toString() {
		return "Event [eId=" + eId + ", sportsName=" + sportsName + ", eventName=" + eventName + ", eventDate="
				+ eventDate + ", eventTime=" + eventTime + ", noOfSlots=" + noOfSlots + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eId;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((eventTime == null) ? 0 : eventTime.hashCode());
		result = prime * result + ((noOfSlots == null) ? 0 : noOfSlots.hashCode());
		result = prime * result + ((sportsName == null) ? 0 : sportsName.hashCode());
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
		Event other = (Event) obj;
		if (eId != other.eId)
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (eventTime == null) {
			if (other.eventTime != null)
				return false;
		} else if (!eventTime.equals(other.eventTime))
			return false;
		if (noOfSlots == null) {
			if (other.noOfSlots != null)
				return false;
		} else if (!noOfSlots.equals(other.noOfSlots))
			return false;
		if (sportsName == null) {
			if (other.sportsName != null)
				return false;
		} else if (!sportsName.equals(other.sportsName))
			return false;
		return true;
	}

}
