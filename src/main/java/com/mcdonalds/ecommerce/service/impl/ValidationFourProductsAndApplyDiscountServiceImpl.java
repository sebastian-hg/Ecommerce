package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.service.ValidationFourProductsAndApplyDiscountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Service
public class ValidationFourProductsAndApplyDiscountServiceImpl implements ValidationFourProductsAndApplyDiscountService {
    @Override
    public Mono<ShoppingCart> execute(ShoppingCart shoppingCart) {
        return null;
    }

    private Mono<ShoppingCart> checkFourProducts(ShoppingCart shoppingCart) {
        return null;
    }

    private Mono<ShoppingCart> applyDiscount(Boolean condition) {

        return null;
    }
}
