package com.beanClasses;

public class CustomerBean {

	private String name;
	private String mobile;
	private String gender;
	private String city;
	private String email;
	private String password;
	private int age;
	
	
	public CustomerBean(String name, String mobile, String gender, String city, String email, String password,int age) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.gender = gender;
		this.city = city;
		this.email = email;
		this.password = password;
		this.age=age;
	}



	public CustomerBean() {
		super();
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + ", gender=" + gender + ", city=" + city + ", email="
				+ email + ", password=" + password + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
