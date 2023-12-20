package com.enes.redis.dto;

public class SaveCityDto {

    private String name;
    private Double population;

    public SaveCityDto() {
    }

    public SaveCityDto(String name, Double population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }


}
