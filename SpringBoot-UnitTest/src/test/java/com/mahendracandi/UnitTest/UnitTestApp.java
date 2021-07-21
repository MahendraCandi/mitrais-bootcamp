package com.mahendracandi.UnitTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTestApp {

    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        int firstNumber = 20;
        int secondNumber = 30;

        // when
        int result = underTest.add(firstNumber, secondNumber);

        // then
        int expectedResult = 50;
        assertThat(result).isEqualTo(expectedResult);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
