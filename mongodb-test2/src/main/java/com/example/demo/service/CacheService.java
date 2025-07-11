package com.example.demo.service;

import com.example.demo.entity.Config;
import com.example.demo.repo.ConfigRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CacheService {
    public HashMap<String, String> configMap;

    @Autowired
    ConfigRepo configRepo;

    @PostConstruct
    public void init() {
        configMap = new HashMap<>();
        List<Config> configList = configRepo.findAll();

        for(Config ltmp: configList) {
            configMap.put(ltmp.getKey(), ltmp.getValue());
        }
    }
}
