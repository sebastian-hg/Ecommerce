package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.service.ValidationFourProductsEqualsAndApplyDiscountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Service
public class ValidationFourProductsEqualsAndApplyDiscountServiceImpl
        implements ValidationFourProductsEqualsAndApplyDiscountService {
    @Override
    public Mono<ShoppingCart> execute() {
        return null;
    }

    private Mono<ShoppingCart> validateFourProductsEquals(ShoppingCart shoppingCart) {
        return null;
    }

    private Mono<ShoppingCart> applyDiscount4x3() {
        return null;
    }
}
