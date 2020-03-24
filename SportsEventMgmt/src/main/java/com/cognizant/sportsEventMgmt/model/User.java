package com.cognizant.sportsEventMgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "emailId") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "*First name is mandatory")
	@Pattern(regexp = "[A-z|\\s]+", message = "*First name should be alphabet only")
	@Size(min = 1, max = 30, message = "*First name should have atleast min 1 and max 30 chars")
	private String firstName;

	@NotEmpty(message = "*Last name is mandatory")
	@Pattern(regexp = "[A-z|\\s]+", message = "*Last name should be alphabet only")
	@Size(min = 1, max = 30, message = "*Last name should have atleast min 1 and max 30 chars")
	private String lastName;

	@NotEmpty(message = "*Email  is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$", message = "*Email should be in proper format 'abc@xyz.com'")
	@Column(unique = true)
	private String emailId;

	@NotEmpty(message = "*Contact number is mandatory")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "*Contact number should be a number of 10 digits, and start with 7/8/9")
	private String contactNumber;

	@NotEmpty(message = "*Age is mandatory")
	@Pattern(regexp = "[1-9][0-9]", message = "*Age should be greater than 9 and less than 100")
	private String age;

	@NotBlank(message = "*Gender is mandatory")
	private String gender;

	@NotEmpty(message = "*Password is mandatory")
	@Pattern(regexp = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+*!=]).*$", message = "*Password should contain atleast 1 uppercase,lowercase and special character")
	@Size(min = 8, max = 15, message = "*Password should contain minimum 8 and maximum 15 characters")
	private String password;

	@NotEmpty(message = "*Please select User")
	private String userType;

	public User(int id, String firstName, String lastName, String emailId, String contactNumber, String age,
			String gender, String password, String userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.userType = userType;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		User other = (User) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

}
