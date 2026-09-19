package com.fleetops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Column(nullable = false)
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Column(nullable = false)
    private String lastName;
    
    @NotBlank(message = "License number is required")
    @Column(nullable = false, unique = true)
    private String licenseNumber;
    
    @NotNull(message = "License expiry date is required")
    @Column(nullable = false)
    private LocalDate licenseExpiryDate;
    
    @Email(message = "Invalid email format")
    @Column
    private String email;
    
    @Column
    private String phone;
    
    @Column
    private LocalDate hireDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DriverStatus status = DriverStatus.ACTIVE;
    
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();
    
    public enum DriverStatus {
        ACTIVE, ON_LEAVE, TERMINATED
    }
    
    // Constructors
    public Driver() {
    }
    
    public Driver(String firstName, String lastName, String licenseNumber, LocalDate licenseExpiryDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.licenseExpiryDate = licenseExpiryDate;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }
    
    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    
    public DriverStatus getStatus() {
        return status;
    }
    
    public void setStatus(DriverStatus status) {
        this.status = status;
    }
    
    public List<Trip> getTrips() {
        return trips;
    }
    
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
    
    // Helper methods
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public boolean isLicenseExpired() {
        return licenseExpiryDate.isBefore(LocalDate.now());
    }
    
    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
