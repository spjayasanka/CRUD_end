package com.example.demo.controller;

import com.example.demo.dto.CountryDto;
import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/v2")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping(value = "/addCountry")
    public void addCountry(@RequestBody CountryDto dto) {
        countryService.addCountry(dto);
    }

    @GetMapping(value = "/showCountries")
    public List<Country> showCountries() {
        return countryService.showCountries();
    }

    @DeleteMapping(value = "/deleteCountry/{name}")
    public void deleteCountry(@PathVariable("name") String name) {
        System.out.println("tested");
        countryService.deleteCountry(name);

    }

    @GetMapping(value = "/getCountry/{name}")
    public Country getCountry(@PathVariable("name") String name) {
        return  countryService.getCountry(name);
    }

    @PutMapping(value = "/update/{name}")
    public Country update(@Validated Country country, @PathVariable("name") String name, @RequestBody CountryDto dto ){
        System.out.println("tested");
        return countryService.update(name, dto);

    }

}




//    @PutMapping("/update/{name}")
//    public ResponseEntity<Country> update(@PathVariable String name, @RequestBody CountryDto countryDto) {
//                return countryService.addCountry(countryDto);
//    }

