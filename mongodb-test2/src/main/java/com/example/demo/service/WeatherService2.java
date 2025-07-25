package com.example.demo.service;

import com.example.demo.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService2 {
    @Value("${apiKey}")
    public String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CacheService cacheService;

    @Autowired
    RedisService redisService;

    @Bean
    @Cacheable
    public WeatherResponse setWeather(String city) {
        String apiURL;
        apiURL = cacheService.configMap.get("weather_api");

        String finalURL = apiURL.replace("CITY", city).replace("APIKEY", apiKey);
        System.out.println("URL created - "+finalURL);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalURL, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();

        redisService.setWeather("weather_for_" + city, body, 300l);
        return body;
    }

}
