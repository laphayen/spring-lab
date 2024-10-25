package com.ssafy.test.dto;

public class Mobile {
	private String code;
	private String model;
	private int price;
	private String company;
	private String userId;
	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Mobile [code=" + code + ", model=" + model + ", price=" + price + ", company=" + company + ", userId="
				+ userId + "]";
	}

	
	
}
