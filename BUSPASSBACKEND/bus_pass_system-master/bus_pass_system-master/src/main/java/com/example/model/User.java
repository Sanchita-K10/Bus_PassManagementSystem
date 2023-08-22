package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="user")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String gender;
	@NotNull
	private String password;
	@NotNull
	private String mobileNo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private Date dob;

	@NotNull
	private String  address;
	@NotNull
	private String type;
	@NotNull
	private boolean typeVerified;

	@NotNull
	private String role;
	private boolean isActive;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date modifiedDate;
	
	private String filename;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isTypeVerified() {
		return typeVerified;
	}

	public void setTypeVerified(boolean typeVerified) {
		this.typeVerified = typeVerified;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", password='" + password + '\'' +
				", mobileNo='" + mobileNo + '\'' +
				", dob=" + dob +
				", address='" + address + '\'' +
				", type='" + type + '\'' +
				", typeVerified=" + typeVerified +
				", role='" + role + '\'' +
				", isActive=" + isActive +
				", createdDate=" + createdDate +
				", modifiedDate=" + modifiedDate +
				'}';
	}
}

