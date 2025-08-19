package com.tnsif.onetoonemapping.controller.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    
	    private String email;
	    
	    private String phoneNumber;
	    
	    private String address;
	    
	    @Temporal(TemporalType.DATE)
	    private Date dateOfBirth;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "profile_id", referencedColumnName = "id")
	    
	    private Profile profile;

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public Date getDateOfBirth() {
	        return dateOfBirth;
	    }

	    public void setDateOfBirth(Date dateOfBirth) {
	        this.dateOfBirth = dateOfBirth;
	    }

	    public Profile getProfile() {
	        return profile;
	    }

	    public void setProfile(Profile profile) {
	        this.profile = profile;
	    }
}
