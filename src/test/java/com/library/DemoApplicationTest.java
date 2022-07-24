package com.library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoApplicationTest {

    Calculate underTest = new Calculate();

    @Test
    public void itShouldAddTwoNumbers() {
        //given
        int numberOne = 20;
        int numberTwo = 30;

        //when
        int result = underTest.add(numberOne, numberTwo);
        //then
        assertThat(result).isEqualTo(50);

    }

    class Calculate {
        int add(int a, int b) {
            return a + b;
        }
    }
}
