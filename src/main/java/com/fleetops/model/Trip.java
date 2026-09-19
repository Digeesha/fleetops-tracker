package com.fleetops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
public class Trip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    @NotNull(message = "Vehicle is required")
    private Vehicle vehicle;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    @NotNull(message = "Driver is required")
    private Driver driver;
    
    @NotNull(message = "Start time is required")
    @Column(nullable = false)
    private LocalDateTime startTime;
    
    @Column
    private LocalDateTime endTime;
    
    @NotNull(message = "Start odometer reading is required")
    @Min(value = 0, message = "Start odometer cannot be negative")
    @Column(nullable = false)
    private Integer startOdometer;
    
    @Min(value = 0, message = "End odometer cannot be negative")
    @Column
    private Integer endOdometer;
    
    @Column(length = 500)
    private String route;
    
    @Column(length = 1000)
    private String notes;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TripStatus status = TripStatus.IN_PROGRESS;
    
    public enum TripStatus {
        IN_PROGRESS, COMPLETED, CANCELLED
    }
    
    // Constructors
    public Trip() {
    }
    
    public Trip(Vehicle vehicle, Driver driver, LocalDateTime startTime, Integer startOdometer) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.startTime = startTime;
        this.startOdometer = startOdometer;
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
    
    public Driver getDriver() {
        return driver;
    }
    
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public Integer getStartOdometer() {
        return startOdometer;
    }
    
    public void setStartOdometer(Integer startOdometer) {
        this.startOdometer = startOdometer;
    }
    
    public Integer getEndOdometer() {
        return endOdometer;
    }
    
    public void setEndOdometer(Integer endOdometer) {
        this.endOdometer = endOdometer;
    }
    
    public String getRoute() {
        return route;
    }
    
    public void setRoute(String route) {
        this.route = route;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public TripStatus getStatus() {
        return status;
    }
    
    public void setStatus(TripStatus status) {
        this.status = status;
    }
    
    // Helper methods
    public Integer getDistance() {
        if (endOdometer != null && startOdometer != null) {
            return endOdometer - startOdometer;
        }
        return 0;
    }
    
    public Long getDurationMinutes() {
        if (endTime != null && startTime != null) {
            return java.time.Duration.between(startTime, endTime).toMinutes();
        }
        return 0L;
    }
    
    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", vehicle=" + (vehicle != null ? vehicle.getLicensePlate() : "null") +
                ", driver=" + (driver != null ? driver.getFullName() : "null") +
                ", startTime=" + startTime +
                ", distance=" + getDistance() +
                ", status=" + status +
                '}';
    }
}
