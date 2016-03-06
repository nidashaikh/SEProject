package com.shopping.model;

public class CustomerPojo {
	private int customerid;
	private String customername;
	private String email;
	private String password;
	private int creditcardno;
	private String address;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCreditcardno() {
		return creditcardno;
	}
	public void setCreditcardno(int creditcardno) {
		this.creditcardno = creditcardno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
