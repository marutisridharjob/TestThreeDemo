package com.example.model;

public class Student {
    
	private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    
    
    public Student(String firstName, String lastName, int age, String address, String city, String state,
			String zipcode) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    	this.address=address;
    	this.city=city;
    	this.state=state;
    	this.zipcode=zipcode;
    	
    	
		// TODO Auto-generated constructor stub
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}