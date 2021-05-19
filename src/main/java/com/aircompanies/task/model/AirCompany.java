package com.aircompanies.task.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public LocalDateTime getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDateTime foundedAt) {
        this.foundedAt = foundedAt;
    }

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
