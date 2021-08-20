package com.example.multiplication.service;

import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import org.springframework.stereotype.Service;

@Service
public interface MultiplicationService {
    /**
     * Creates Multiplication object with two
     * random factors
     * @return a Multiplication object with random factors
     */
    Multiplication createMultiplication();

    /**
     * @return true is attempt matches the result of multiplication, false otherwise
     */
    boolean checkAttempt(MultiplicationResultAttempt multiplicationResultAttempt);
}
