package com.mcdonalds.ecommerce.service;

import com.mcdonalds.ecommerce.model.Product;
import com.mcdonalds.ecommerce.model.ShoppingCart;
import reactor.core.publisher.Mono;

public interface AddProductToShoppingCartService {
    Mono<ShoppingCart> execute(Product product);
}
