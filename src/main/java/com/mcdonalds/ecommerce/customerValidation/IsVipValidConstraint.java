package com.mcdonalds.ecommerce.customerValidation;

import com.mcdonalds.ecommerce.customerValidation.impl.ClientVIPValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ClientVIPValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsVipValidConstraint {

    String message() default "Invalid value for type of client";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
