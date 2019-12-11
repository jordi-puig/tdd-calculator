package com.calculator;

public class CalculatorException extends Exception {

    private static final long serialVersionUID = 1L;

    public CalculatorException(Exception e) {
        super(e);
    }

}
