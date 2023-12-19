package com.enes.redis.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Cacheable("alphabet")
    public String getAlphabet() {
        try {
            Thread.sleep(5000);
            return "abcdefghijklmnopqrstuvwxyz";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
