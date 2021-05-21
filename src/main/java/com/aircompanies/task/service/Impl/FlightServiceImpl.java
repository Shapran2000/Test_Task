package com.aircompanies.task.service.Impl;


import com.aircompanies.task.exception.NullEntityReferenceException;
import com.aircompanies.task.exception.ValidationException;
import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.model.Flight;
import com.aircompanies.task.repository.FlightRepository;
import com.aircompanies.task.service.FlightService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight create(Flight flight) {
        if (flight != null) {
            return flightRepository.save(flight);
        }
        throw new NullPointerException("AirCompany cannot be 'null'");
    }

    @Override
    public Flight readById(long id) {
        return flightRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("AirCompany with id " + id + " not found"));

    }

    @Override
    public Flight update(Flight flight) {
        if (flight != null) {
            readById(flight.getId());
            return flightRepository.save(flight);
        }
        throw new NullEntityReferenceException("AirCompany cannot be 'null'");

    }

    @Override
    public void delete(long id) {
        Flight flight = readById(id);
        flightRepository.delete(flight);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> findFlightByStatus(String status,String name)throws ValidationException{
        List<Flight> flight = flightRepository.findByFlightStatus(status, name);
        if (flight==null){
            throw new ValidationException("Flight not Found!");
        }
        return flight;
    }
}
