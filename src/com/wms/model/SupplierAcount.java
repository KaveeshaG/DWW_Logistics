package com.wms.model;

public class SupplierAcount {
	private String supplierId;
	private String name;
	private String userName;
	private String password;
	private String address;
	private String email;
	private String contactNo;
	private String review;

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "SupplierAcount [supplierId=" + supplierId + ", name=" + name + ", userName=" + userName + ", password="
				+ password + ", address=" + address + ", email=" + email + ", contactNo=" + contactNo + ", review="
				+ review + "]";
	}
	
	
	

	
}
