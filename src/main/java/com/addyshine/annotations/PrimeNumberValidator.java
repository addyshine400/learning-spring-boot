package com.addyshine.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class PrimeNumberValidator implements ConstraintValidator<primeNumber, Integer> {

    @Override
    public  boolean
    isValid(Integer value, ConstraintValidatorContext context) {
        if(value == null || value<2) {
            return false;
        }
        for(int i=2;i<=Math.sqrt(value);i++){
            if(value%i==0){
                return false;
            }
        }
        return true;
    }



}
