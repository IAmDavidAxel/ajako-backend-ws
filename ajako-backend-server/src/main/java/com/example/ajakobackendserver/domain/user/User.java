package com.example.ajakobackendserver.domain.user;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;
	@Column(name = "address")
	private String address;
	@Column(name = "zip_code")
	private String zipCode;
	@Column(name="city")
	private String city;

	public String getUsername() {
		return username;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getCountry() {
		return country;
	}

	@Column(name="province")
	private String province;

	@Column(name = "country")
	private String country;

	public User(String name, String lastName, String dateOfBirth, String phoneNumber, String password, String email, String username, String address, String zipCode, String city, String province, String country) {
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.username = username;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.province = province;
		this.country = country;
	}




	public User(){

	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
}
