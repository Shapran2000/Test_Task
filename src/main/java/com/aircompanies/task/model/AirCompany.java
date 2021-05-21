package com.aircompanies.task.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "air_сompanies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "founded_at", nullable = false)
    private LocalDateTime foundedAt;

    @JsonBackReference
    @OneToMany(mappedBy = "airCompany", cascade = CascadeType.REMOVE)
    private List<Flight> myFlight;

    @JsonBackReference
    @OneToMany(mappedBy = "myAirCompany", cascade = CascadeType.REMOVE)
    private List<Airplane> myAirplanes;

    @Override
    public String toString() {
        return "AirCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyType='" + companyType + '\'' +
                ", foundedAt=" + foundedAt +
                '}';
    }
}
