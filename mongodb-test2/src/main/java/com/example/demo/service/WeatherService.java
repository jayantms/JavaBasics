package com.example.demo.service;

import com.example.demo.api.response.WeatherResponse;
import com.example.demo.entity.Config;
import com.example.demo.repo.ConfigRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Component
public class WeatherService {
    //private static final String apiKey = "4e572862324868e66e332e4e01493dd2";
    //String apiURL = "http://api.weatherstack.com/current?access_key=APIKEY&query=CITY;";

    @Value("${apiKey}")
    public String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CacheService cacheService;

    public WeatherResponse getWeather(String city) {
        String apiURL;
        apiURL = cacheService.configMap.get("weather_api");

        String finalURL = apiURL.replace("CITY", city).replace("APIKEY", apiKey);
        System.out.println("URL created - "+finalURL);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalURL, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
