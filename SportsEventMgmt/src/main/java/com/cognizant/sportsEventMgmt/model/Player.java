package com.cognizant.sportsEventMgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pId;

	@NotNull(message = "*Coach id is mandatory")
	int cId;

	@NotEmpty(message = "*Player name is mandatory")
	@Pattern(regexp = "[A-z|\\s]+", message = "*Player name should be alphabet only")
	@Size(min = 1, max = 30, message = "*Player name should have atleast min 1 and max 30 chars")
	String playerName;

	@NotEmpty(message = "*Email Id  is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$", message = "*Email should be in proper format 'abc@xyz.com'")
	String emailId;

	@NotEmpty(message = "*Contact number is mandatory")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "*Contact number should be a number of 10 digits, and start with 7/8/9")
	String contactNumber;

	@NotEmpty(message = "*Age is mandatory")
	@Pattern(regexp = "[1-9][0-9]", message = "*Age should be greater than 9 and less than 100")
	String age;

	@NotBlank(message = "*Gender is mandatory")
	String gender;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int pId, @NotNull(message = "*Coach id is mandatory") int cId,
			@NotEmpty(message = "*Player name is mandatory") @Pattern(regexp = "[A-z|\\s]+", message = "*Player name should be alphabet only") @Size(min = 1, max = 30, message = "*Player name should have atleast min 1 and max 30 chars") String playerName,
			@NotEmpty(message = "*Email Id  is mandatory") @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "*Email should be in proper format 'abc@xyz.com'") String emailId,
			@NotEmpty(message = "*Contact number is mandatory") @Pattern(regexp = "[7-9][0-9]{9}", message = "*Contact number should be a number of 10 digits, and start with 7/8/9") String contactNumber,
			@NotEmpty(message = "*Age is mandatory") @Pattern(regexp = "[1-9][0-9]", message = "Age should be greater than 9 and less than 100") String age,
			@NotBlank(message = "*Gender is mandatory") String gender) {
		super();
		this.pId = pId;
		this.cId = cId;
		this.playerName = playerName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.age = age;
		this.gender = gender;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + cId;
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + pId;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
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
		Player other = (Player) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (cId != other.cId)
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (pId != other.pId)
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [pId=" + pId + ", cId=" + cId + ", playerName=" + playerName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", age=" + age + ", gender=" + gender + "]";
	}

}
