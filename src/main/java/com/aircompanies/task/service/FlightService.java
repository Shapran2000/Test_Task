package com.aircompanies.task.service;

import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.model.Flight;

import java.util.List;

public interface FlightService {
    Flight create(Flight flight);
    Flight readById(long id);
    Flight update(Flight flight);
    Flight changeFlightStatus(String status,long id);
    void delete(long id);
    List<Flight> getAll();
    List<Flight> findFlightByStatus(String status ,String name);
    List<Flight> findAllFlightInActive();

}
