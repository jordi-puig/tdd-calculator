package com.calculator;

import java.lang.reflect.Method;

import exceptions.OverflowException;

public class CalcProxy {

    private Calculator calculator;
    private LimitsValidator validator;

    public CalcProxy(Calculator calculator, LimitsValidator validator) {
        this.validator = validator;
        this.calculator = calculator;
    }

    public int binaryOperation(OperationType operation, int arg1, int arg2) throws OverflowException {
        int result = 0;
        Method method = null;
        try {
            validator.validateArgs(arg1, arg2);
            method = calculator.getClass().getDeclaredMethod(operation.name(), int.class, int.class);
            result = ((Integer) method.invoke(calculator, arg1, arg2)).intValue();
            validator.validateResult(result);
        } catch (OverflowException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public LimitsValidator getValidator() {
        return validator;
    }

    public void setValidator(LimitsValidator validator) {
        this.validator = validator;
    }

}
