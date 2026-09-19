package com.fleetops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Make is required")
    @Column(nullable = false)
    private String make;
    
    @NotBlank(message = "Model is required")
    @Column(nullable = false)
    private String model;
    
    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be after 1900")
    @Max(value = 2100, message = "Year must be before 2100")
    @Column(nullable = false)
    private Integer year;
    
    @NotBlank(message = "VIN is required")
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    @Column(nullable = false, unique = true, length = 17)
    private String vin;
    
    @NotBlank(message = "License plate is required")
    @Column(nullable = false, unique = true)
    private String licensePlate;
    
    @NotNull(message = "Current mileage is required")
    @Min(value = 0, message = "Mileage cannot be negative")
    @Column(nullable = false)
    private Integer currentMileage;
    
    @Column
    private String color;
    
    @Column
    private LocalDate purchaseDate;
    
    @Column
    private Double purchasePrice;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleStatus status = VehicleStatus.ACTIVE;
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trip> trips = new ArrayList<>();
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuelPurchase> fuelPurchases = new ArrayList<>();
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceRecord> maintenanceRecords = new ArrayList<>();
    
    public enum VehicleStatus {
        ACTIVE, IN_MAINTENANCE, RETIRED
    }
    
    // Constructors
    public Vehicle() {
    }
    
    public Vehicle(String make, String model, Integer year, String vin, String licensePlate, Integer currentMileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.currentMileage = currentMileage;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String getVin() {
        return vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public Integer getCurrentMileage() {
        return currentMileage;
    }
    
    public void setCurrentMileage(Integer currentMileage) {
        this.currentMileage = currentMileage;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public Double getPurchasePrice() {
        return purchasePrice;
    }
    
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public VehicleStatus getStatus() {
        return status;
    }
    
    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
    
    public List<Trip> getTrips() {
        return trips;
    }
    
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
    
    public List<FuelPurchase> getFuelPurchases() {
        return fuelPurchases;
    }
    
    public void setFuelPurchases(List<FuelPurchase> fuelPurchases) {
        this.fuelPurchases = fuelPurchases;
    }
    
    public List<MaintenanceRecord> getMaintenanceRecords() {
        return maintenanceRecords;
    }
    
    public void setMaintenanceRecords(List<MaintenanceRecord> maintenanceRecords) {
        this.maintenanceRecords = maintenanceRecords;
    }
    
    // Helper methods
    public String getDisplayName() {
        return year + " " + make + " " + model;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", vin='" + vin + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", currentMileage=" + currentMileage +
                ", status=" + status +
                '}';
    }
}
