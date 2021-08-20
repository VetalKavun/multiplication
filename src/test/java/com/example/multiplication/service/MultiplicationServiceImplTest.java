package com.example.multiplication.service;


import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

public class MultiplicationServiceImplTest {

    @Mock
    private RandomGeneratorService randomGeneratorService;
    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Before
    public void setUp() {
        //with this call we tell mockito to process the annotation
        MockitoAnnotations.openMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void createRandomMultiplicationTest() {
        //given RandomGeneratorService will return first 50, then 30
        given(randomGeneratorService.generateRandomFactor())
                .willReturn(50, 30);
        //when
        Multiplication multiplication = multiplicationServiceImpl.createMultiplication();
        //then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
    }

    @Test
    public void checkCorrectAttemptTest() {
        //given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("john_doe");
        MultiplicationResultAttempt multiplicationResultAttempt = new MultiplicationResultAttempt(
                multiplication, user, 3000);
        //when
        boolean attemptResult = multiplicationServiceImpl.checkAttempt(multiplicationResultAttempt);
        //assert
        assertThat(attemptResult).isTrue();
    }

    @Test
    public void checkIncorrectAttemptTest() {
        //given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("john_doe");
        MultiplicationResultAttempt multiplicationResultAttempt = new MultiplicationResultAttempt(
                multiplication, user, 3010);
        //when
        boolean attemptResult = multiplicationServiceImpl.checkAttempt(multiplicationResultAttempt);
        //assert
        assertThat(attemptResult).isFalse();
    }
}
