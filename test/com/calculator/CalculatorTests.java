package com.calculator;

import org.junit.jupiter.api.BeforeEach;

class CalculatorTests {

    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        LimitsValidator limitsValidator = new LimitsValidator(-100, 100);
    }

}
