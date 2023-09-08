package com.countryinfo.IndividualAssignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/random", produces = "application/json")
    public CountryInfo getCountry() {
        try {
            String url = "https://restcountries.com/v3/all";
            ObjectMapper mapper = new ObjectMapper();

            String jsonCountry = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonCountry);

            //Gets the size of the API list
            int totalCountries = root.size();

            //Picks a random Country from the API List
            Random random = new Random();
            int randomIndex = random.nextInt(totalCountries);
            JsonNode country = root.get(randomIndex);

            //Gets the Information of the random Country that was chosen.
            String countryName = country.get("name").get("common").asText();
            String area = country.get("area").asText();
            String population = country.get("population").asText();
            
            //returns that information
            CountryInfo countryInfo = new CountryInfo(countryName, area, population);
            return countryInfo;

        } 

        //throws error if it can't get the API information
        catch (JsonProcessingException ex) {
            System.out.println("Error getting Country");
            return null;
        }

    }

    
}
