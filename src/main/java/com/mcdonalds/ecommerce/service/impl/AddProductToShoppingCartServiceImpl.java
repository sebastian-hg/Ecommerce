package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.model.Product;
import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.service.AddProductToShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Service
public class AddProductToShoppingCartServiceImpl implements AddProductToShoppingCartService {
    @Override
    public Mono<ShoppingCart> execute(Product product) {
        return null;
    }
}
