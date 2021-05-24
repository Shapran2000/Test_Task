package com.aircompanies.task.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "factory_serial_number", nullable = false, unique = true)
    private long factorySerialNumber;

    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany myAirCompany;


    @Column(name = "number_of_flights")
    private long numberOfFlights;

    @Column(name = "flight_distance")
    private long flightDistance;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", factorySerialNumber=" + factorySerialNumber +
                ", airCompany=" + myAirCompany +
                ", numberOfFlights=" + numberOfFlights +
                ", flightDistance=" + flightDistance +
                ", fuelCapacity=" + fuelCapacity +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
