package com.calculator;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.OverflowException;

class CalcProxyTests {

    CalcProxy proxy = null;

    @BeforeEach
    public void setUp() {
        proxy = new CalcProxy(new Calculator(), new LimitsValidator(-10, 10));
    }

    @Test
    public void add() throws OverflowException {
        int result = proxy.binaryOperation(OperationType.add, 2, 2);
        assertEquals(4, result);
    }

    @Test
    public void addWithDifferentArguments() throws OverflowException {
        int result = proxy.binaryOperation(OperationType.add, 2, 7);
        assertEquals(9, result);
    }

    @Test
    public void substract() throws OverflowException {
        int result = proxy.binaryOperation(OperationType.substract, 5, 3);
        assertEquals(2, result);
    }

    @Test
    public void substractReturningNegative() throws OverflowException {
        int result = proxy.binaryOperation(OperationType.substract, 3, 5);
        assertEquals(-2, result);
    }

    @Test
    public void substractSettingLimitValues() throws OverflowException {
        int result = proxy.binaryOperation(OperationType.substract, 5, 10);
        assertEquals(-5, result);
    }

    @Test
    public void substractExcedingLowerLimit() {
        try {
            proxy.binaryOperation(OperationType.substract, 10, 150);
            fail("Exception is not being thrown when exceeding lower limit");
        } catch (OverflowException e) {
            // Ok, the SUT works as expected
        }

    }

    @Test
    public void addExcedingUpperLimit() {
        try {
            proxy.binaryOperation(OperationType.substract, 10, 150);
            fail("Exception is not being thrown when exceeding upper limit");
        } catch (OverflowException e) {
            // Ok, the SUT works as expected
        }

    }

    @Test
    public void setAndGetUpperLimit() {
        assertEquals(10, proxy.getValidator().getUpperLimit());
        assertEquals(-10, proxy.getValidator().getLowerLimit());
    }

    @Test
    public void argumentsExceedLimits() {
        try {
            proxy.getValidator().validateArgs(proxy.getValidator().getUpperLimit() + 1, proxy.getValidator().getLowerLimit() - 1);
            fail("This should fail: arguments exceeding limit");
        } catch (OverflowException e) {
            // Ok, the SUT works as expected
        }
    }

    @Test
    public void argumentsExceedLimitsInverse() {
        try {
            proxy.getValidator().validateArgs(proxy.getValidator().getLowerLimit() - 1, proxy.getValidator().getUpperLimit() + 1);
            fail("This should fail: arguments exceeding limit");
        } catch (OverflowException e) {
            // Ok, the SUT works as expected
        }
    }

    @Test
    public void argumentsExceedLimitsOnSubstract() {
        try {
            proxy.binaryOperation(OperationType.substract, proxy.getValidator().getUpperLimit() + 1, proxy.getValidator().getLowerLimit() - 1);
            fail("This should fail: arguments exceeding limit");
        } catch (OverflowException e) {
            // Ok, the SUT works as expected
        }
    }

    @Test
    public void argumentsExceedLimitsInverseOnSubstract() {
        try {
            proxy.binaryOperation(OperationType.substract, proxy.getValidator().getLowerLimit() - 1, proxy.getValidator().getUpperLimit() + 1);
            fail("This should fail: arguments exceeding limit");
        } catch (OverflowException e) {
            // Ok, the SUT works as expected
        }
    }

}
