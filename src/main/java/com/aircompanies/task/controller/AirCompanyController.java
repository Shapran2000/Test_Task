package com.aircompanies.task.controller;


import com.aircompanies.task.exception.ValidationException;
import com.aircompanies.task.model.AirCompany;
import com.aircompanies.task.service.AirCompanyService;

import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircompany")
public class AirCompanyController {

    private final AirCompanyService airCompanyService;


    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }


    @PostMapping("/create")
    public AirCompany create(@RequestBody @Validated AirCompany airCompany, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException();
        }
        AirCompany newAirCompany = airCompanyService.create(airCompany);
        return newAirCompany;
    }


    @GetMapping("/{id}/read")
    public AirCompany read(@PathVariable long id) {
        AirCompany airCompany = airCompanyService.readById(id);
        return airCompany;
    }

    @PostMapping("/{id}/update")
    public AirCompany update(@PathVariable long id,
                             @RequestBody @Validated AirCompany airCompany, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException();
        }
        airCompanyService.update(airCompany);
        return airCompany;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {

        airCompanyService.delete(id);
        return "redirect:/aircompany/all";
    }

    @GetMapping("/all")
    public List<AirCompany> getAll() {
        List<AirCompany> airCompanyList = airCompanyService.getAll();
        return airCompanyList;
    }


}
