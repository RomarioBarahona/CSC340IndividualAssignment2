package com.countryinfo.IndividualAssignment2;


//Setters and Getters on the Information about the Country
public class CountryInfo {
    private String countryName;
    private String area;
    private String population;

    public CountryInfo(String countryName, String area, String population) {
        this.countryName = countryName;
        this.area = area;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}

