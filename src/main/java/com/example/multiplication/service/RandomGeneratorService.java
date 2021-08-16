package com.example.multiplication.service;

import org.springframework.stereotype.Service;

@Service
public interface RandomGeneratorService {
    /**
     * @return a randomly generated factor.
     * It's always a number between 11 and 99
     */
    int generateRandomFactor();
}
