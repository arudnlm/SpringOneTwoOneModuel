package com.tcs.trs.dto;

import java.time.LocalDate;

public class CustomerDTO {
	
	private Integer customerId;
	private String name;
	private String emailId;
	private LocalDate dateOfBirth; 
	
	private AddressDTO address;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + "]";
	}
	
	

}