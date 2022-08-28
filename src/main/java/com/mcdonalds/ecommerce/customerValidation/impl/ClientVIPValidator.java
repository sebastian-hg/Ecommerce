package com.mcdonalds.ecommerce.customerValidation.impl;

import com.mcdonalds.ecommerce.customerValidation.IsVipValidConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientVIPValidator implements ConstraintValidator<IsVipValidConstraint, Boolean> {


    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext context) {
        return value == Boolean.TRUE || value == Boolean.FALSE ;
    }
}
