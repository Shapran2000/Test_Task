package com.aircompanies.task.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "factory_serial_number", nullable = false)
    private long factorySerialNumber;

    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    @Column(name = "number_of_flights")
    private long numberOfFlights;

    @Column(name = "flight_distance")
    private long flightDistance;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(long factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public long getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(long numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public long getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(long flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", factorySerialNumber=" + factorySerialNumber +
                ", airCompany=" + airCompany +
                ", numberOfFlights=" + numberOfFlights +
                ", flightDistance=" + flightDistance +
                ", fuelCapacity=" + fuelCapacity +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
