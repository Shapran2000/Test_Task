package com.aircompanies.task.controller;


import com.aircompanies.task.exception.ValidationException;
import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.model.Airplane;
import com.aircompanies.task.service.AirCompanyService;
import com.aircompanies.task.service.AirplaneService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    private final AirplaneService airplaneService;
    private final AirCompanyService airCompanyService;

    public AirplaneController(AirplaneService airplaneService, AirCompanyService airCompanyService) {
        this.airplaneService = airplaneService;
        this.airCompanyService = airCompanyService;
    }

    @PostMapping("/{company_id}/add-airplane")
    public List<Airplane> addAirplane(@PathVariable("company_id") long company_id, @Validated @ModelAttribute("airplane") Airplane airplane, BindingResult result){
        if (result.hasErrors()) {
            throw new ValidationException();
        }
        AirCompany airCompany = airCompanyService.readById(company_id);
        Airplane newAirplane = airplaneService.create(airplane);
        List<Airplane> airplanes = airCompany.getMyAirplanes();
        airplanes.add(newAirplane);
        return airplanes;
    }
    @GetMapping("/all")
    public List<Airplane> getAll(){
        List<Airplane> airplanes = airplaneService.getAll();
        return airplanes;
    }

}
