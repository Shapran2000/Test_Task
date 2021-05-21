package com.aircompanies.task.service.Impl;


import com.aircompanies.task.exception.NullEntityReferenceException;
import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.model.Airplane;
import com.aircompanies.task.repository.AirplaneRepository;
import com.aircompanies.task.service.AirplaneService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public Airplane create(Airplane airplane) {
        if (airplane != null) {
            return airplaneRepository.save(airplane);
        }
        throw new NullPointerException("Airplane cannot be 'null'");
    }

    @Override
    public Airplane readById(long id) {
        return airplaneRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Airplane with id " + id + " not found"));
    }

    @Override
    public Airplane update(Airplane airplane) {
        if (airplane != null) {
            readById(airplane.getId());
            return airplaneRepository.save(airplane);
        }
        throw new NullEntityReferenceException("Airplane cannot be 'null'");
    }

    @Override
    public Airplane findByName(String name) {
        return airplaneRepository.findAirplaneByName(name);
    }

    @Override
    public void delete(long id) {
        Airplane airplane = readById(id);
        airplaneRepository.delete(airplane);
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }
}
