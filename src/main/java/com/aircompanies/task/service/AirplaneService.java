package com.aircompanies.task.service;

import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.model.Airplane;

import java.util.List;

public interface AirplaneService {
    Airplane create(Airplane airplane);
    Airplane readById(long id);
    Airplane update(Airplane airplane);
    Airplane findByName (String name);
    void delete(long id);
    List<Airplane> getAll();
}
