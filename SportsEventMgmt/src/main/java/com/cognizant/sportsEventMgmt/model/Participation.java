package com.cognizant.sportsEventMgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Participation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int partId;

	@NotNull(message = "*event id is mandatory")
	int eId;

	@NotNull(message = "*Coach id is mandatory")
	int cId;

	@NotEmpty(message = "*Status is mandatory")
	@Pattern(regexp = "[A-z|\\s]+", message = "*Status should be alphabet only")
	String status;

	public Participation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participation(int partId, @NotNull(message = "*event id is mandatory") int eId,
			@NotNull(message = "*Coach id is mandatory") int cId,
			@NotEmpty(message = "*Status is mandatory") @Pattern(regexp = "[A-z|\\s]+", message = "*Status should be alphabet only") String status) {
		super();
		this.partId = partId;
		this.eId = eId;
		this.cId = cId;
		this.status = status;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "participation [partId=" + partId + ", eId=" + eId + ", cId=" + cId + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + eId;
		result = prime * result + partId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Participation other = (Participation) obj;
		if (cId != other.cId)
			return false;
		if (eId != other.eId)
			return false;
		if (partId != other.partId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}