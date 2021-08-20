package com.example.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public final class MultiplicationResultAttempt {
    private final Multiplication multiplication;
    private final User user;
    private final int resultAttempt;

    public MultiplicationResultAttempt() {
        this.multiplication = null;
        this.resultAttempt = -1;
        this.user = null;
    }
}
