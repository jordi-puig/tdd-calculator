package com.calculator;

import exceptions.OverflowException;

public interface Validator {

    public void setLimits(int lowerLimit, int upperLimit);

    public boolean validateArgs(int i, int j) throws OverflowException;

    public boolean validateResult(int i) throws OverflowException;

}
