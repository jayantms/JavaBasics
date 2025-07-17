package com.example.demo.service;

import com.example.demo.api.response.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    public <T> T getWeather(String key, Class<T> weatherResponseClass) {
        try {
            Object val = redisTemplate.opsForValue().get(key);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(val.toString(), weatherResponseClass);
        } catch (Exception ex) {
            log.error("Caught in exception");
            return null;
        }
    }

    public void setWeather(String key, Object weatherObj, Long ttl) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue = mapper.writeValueAsString(weatherObj);
            redisTemplate.opsForValue().set(key, jsonValue, ttl, TimeUnit.SECONDS);
        } catch (Exception ex) {
            log.error("Caught in exception");
        }
    }
}
