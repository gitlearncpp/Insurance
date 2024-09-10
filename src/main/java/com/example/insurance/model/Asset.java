package com.example.insurance.model;

import jakarta.persistence.*;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private int yearBuilt;
    private double buildingValue;
    private double contentValue;
    private double premium;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getYearBuilt() { return yearBuilt; }
    public void setYearBuilt(int yearBuilt) { this.yearBuilt = yearBuilt; }

    public double getBuildingValue() { return buildingValue; }
    public void setBuildingValue(double buildingValue) { this.buildingValue = buildingValue; }

    public double getContentValue() { return contentValue; }
    public void setContentValue(double contentValue) { this.contentValue = contentValue; }

    public double getPremium() { return premium; }
    public void setPremium(double premium) { this.premium = premium; }
}