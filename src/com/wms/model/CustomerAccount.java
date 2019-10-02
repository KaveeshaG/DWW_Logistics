package com.wms.model;

public class CustomerAccount {

	
	private int customerId;
	private String customerName;
	private String type;
	private String email;
	private String mobile;
	private String password;
	private String nic;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	@Override
	public String toString() {
		return "CustomerAccount [customerId=" + customerId + ", customerName=" + customerName + ", type=" + type
				+ ", email=" + email + ", mobile=" + mobile + ", password=" + password + ", nic=" + nic + "]";
	}

}
