package com.api.classes;

import java.util.List;

public class User {
public String firstName;
public String lastName;
public Integer age;
public Address address;
public List<PhoneNumbers> phoneNumbers;
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
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<PhoneNumbers> getPhonenumbers() {
	return phoneNumbers;
}
public void setPhonenumbers(List<PhoneNumbers> phonenumbers) {
	this.phoneNumbers = phonenumbers;
}


}
