package com.enes.redis.controller;


import com.enes.redis.dto.SaveCityDto;
import com.enes.redis.model.City;
import com.enes.redis.service.CityService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all") // WHEN GETTING A CITY, GET IT FROM CACHE
    public List<City> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/get/{id}") // WHEN GETTING A CITY, GET IT FROM CACHE
    @Cacheable(value = "cities", key = "#id")
    public City get(@PathVariable Long id) {
        return cityService.get(id);
    }

    @PostMapping("/save") // WHEN SAVING A CITY, SAVE IT TO CACHE
    public void saveAll(@RequestBody List<SaveCityDto> saveCityDto) {
        cityService.saveAll(saveCityDto);
    }

    @DeleteMapping("/delete/{id}")
    @CacheEvict(value = "cities", key = "#id") // WHEN REMOVING A CITY, REMOVE IT FROM CACHE
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

}
