package com.aircompanies.task.service.Impl;

import com.aircompanies.task.exception.NullEntityReferenceException;
import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.repository.AirCompanyRepository;
import com.aircompanies.task.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private AirCompanyRepository airCompanyRepository;

    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public AirCompany create(AirCompany airCompany) {
        if (airCompany != null) {
            return airCompanyRepository.save(airCompany);
        }
        throw new NullPointerException("AirCompany cannot be 'null'");
    }

    @Override
    public AirCompany readById(long id) {
        return airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("AirCompany with id " + id + " not found"));
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        if (airCompany != null) {
            readById(airCompany.getId());
            return airCompanyRepository.save(airCompany);
        }
        throw new NullEntityReferenceException("AirCompany cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        AirCompany airCompany = readById(id);
        airCompanyRepository.delete(airCompany);
    }

    @Override
    public List<AirCompany> getAll() {
        return airCompanyRepository.findAll();
    }

    @Override
    public AirCompany findByName(String name) {
        return airCompanyRepository.findAirCompanyByName(name);
    }
}
