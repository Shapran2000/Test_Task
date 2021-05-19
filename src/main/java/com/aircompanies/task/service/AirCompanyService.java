package com.aircompanies.task.service;

import com.aircompanies.task.model.AirCompany;

import java.util.List;

public interface AirCompanyService {
    AirCompany create(AirCompany airCompany);
    AirCompany readById(long id);
    AirCompany update(AirCompany airCompany);
    void delete(long id);
    List<AirCompany> getAll();
}
