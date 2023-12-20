package com.enes.redis.service;


import com.enes.redis.dto.SaveCityDto;
import com.enes.redis.model.City;
import com.enes.redis.repository.CityRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {


    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        List<City> cities = cityRepository.findAll();
        System.out.printf("Retrieving %d cities from database\n", cities.size());
        return cities;
    }

    @Cacheable(value = "cities", key = "#id")
    public City get(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        System.out.printf("Retrieving city with id %d from database\n", id);
        return city;
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    public void saveAll(List<SaveCityDto> saveCityDto) {
        List<City> cities = new ArrayList<>();
        for (SaveCityDto cityDto : saveCityDto) {
            City city = new City();
            city.setName(cityDto.getName());
            city.setPopulation(cityDto.getPopulation());
            cities.add(city);
        }
        System.out.printf("Saving %d cities to database\n", cities.size());
        cityRepository.saveAll(cities);
    }
}
