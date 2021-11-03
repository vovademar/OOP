package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void initCalc() {
        calculator = new Calculator();
    }

    @Test
    public void sum_test() {
        Assertions.assertEquals(2.0, calculator.startCalculate("+ 1 1"));
    }

    @Test
    public void sub_test() {
        Assertions.assertEquals(4.1, calculator.startCalculate("- 5.2 1.1"));
    }

    @Test
    public void div_test() {
        Assertions.assertEquals(6.0, calculator.startCalculate("/ 12 2"));
    }

    @Test
    public void mul_test() {
        Assertions.assertEquals(-2.0, calculator.startCalculate("* -2 1"));
    }

    @Test
    public void log_test() {
        Assertions.assertEquals(Math.log(2), calculator.startCalculate("log 2"));
    }

    @Test
    public void pow_test() {
        Assertions.assertEquals(8.0, calculator.startCalculate("pow 2 3"));
    }

    @Test
    public void sin_test() {
        Assertions.assertEquals(Math.sin(3), calculator.startCalculate("sin 3"));
    }

    @Test
    public void cos_test() {
        Assertions.assertEquals(Math.cos(2), calculator.startCalculate("cos 2"));
    }
    @Test
    public void sqrt_test() {
        Assertions.assertEquals(3.0, calculator.startCalculate("sqrt 9"));
    }
    @Test
    public void wrong_action_test() {
        Assertions.assertEquals(0.0, calculator.startCalculate("mod 333"));
    }
}
