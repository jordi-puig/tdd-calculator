
package com.calculator;

import exceptions.OverflowException;

public class LimitsValidator implements Validator {

    private int upperLimit;
    private int lowerLimit;

    public LimitsValidator(int lowerLimit, int upperLimit) {
        setLimits(lowerLimit, upperLimit);
    }

    public void setLimits(int lowerLimit, int upperLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    public boolean validateArgs(int i, int j) throws OverflowException {
        if (i > upperLimit) throw new OverflowException("First argument exdeeded upper limit");
        if (j < lowerLimit) throw new OverflowException("Second argument exdeeded lower limit");

        if (i < lowerLimit) throw new OverflowException("First argument exdeeded lower limit");
        if (j > upperLimit) throw new OverflowException("Second argument exdeeded upper limit");

        return true;
    }

    public boolean validateResult(int result) throws OverflowException {
        if (result > upperLimit) throw new OverflowException("Result argument exdeeded upper limit");
        if (result < lowerLimit) throw new OverflowException("Result argument exdeeded lower limit");

        return true;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

}
