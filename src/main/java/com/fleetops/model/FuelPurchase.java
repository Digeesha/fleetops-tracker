package com.fleetops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fuel_purchases")
public class FuelPurchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    @NotNull(message = "Vehicle is required")
    private Vehicle vehicle;
    
    @NotNull(message = "Purchase date is required")
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    
    @NotNull(message = "Gallons is required")
    @DecimalMin(value = "0.1", message = "Gallons must be greater than 0")
    @Column(nullable = false)
    private Double gallons;
    
    @NotNull(message = "Cost per gallon is required")
    @DecimalMin(value = "0.01", message = "Cost per gallon must be greater than 0")
    @Column(nullable = false)
    private Double costPerGallon;
    
    @NotNull(message = "Odometer reading is required")
    @Min(value = 0, message = "Odometer reading cannot be negative")
    @Column(nullable = false)
    private Integer odometerReading;
    
    @Column(length = 200)
    private String station;
    
    @Column(length = 500)
    private String notes;
    
    @Column
    private Double calculatedMpg;
    
    // Constructors
    public FuelPurchase() {
    }
    
    public FuelPurchase(Vehicle vehicle, LocalDateTime purchaseDate, Double gallons, 
                       Double costPerGallon, Integer odometerReading) {
        this.vehicle = vehicle;
        this.purchaseDate = purchaseDate;
        this.gallons = gallons;
        this.costPerGallon = costPerGallon;
        this.odometerReading = odometerReading;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public Double getGallons() {
        return gallons;
    }
    
    public void setGallons(Double gallons) {
        this.gallons = gallons;
    }
    
    public Double getCostPerGallon() {
        return costPerGallon;
    }
    
    public void setCostPerGallon(Double costPerGallon) {
        this.costPerGallon = costPerGallon;
    }
    
    public Integer getOdometerReading() {
        return odometerReading;
    }
    
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }
    
    public String getStation() {
        return station;
    }
    
    public void setStation(String station) {
        this.station = station;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public Double getCalculatedMpg() {
        return calculatedMpg;
    }
    
    public void setCalculatedMpg(Double calculatedMpg) {
        this.calculatedMpg = calculatedMpg;
    }
    
    // Helper methods
    public Double getTotalCost() {
        return gallons * costPerGallon;
    }
    
    @Override
    public String toString() {
        return "FuelPurchase{" +
                "id=" + id +
                ", vehicle=" + (vehicle != null ? vehicle.getLicensePlate() : "null") +
                ", purchaseDate=" + purchaseDate +
                ", gallons=" + gallons +
                ", totalCost=" + getTotalCost() +
                ", mpg=" + calculatedMpg +
                '}';
    }
}
