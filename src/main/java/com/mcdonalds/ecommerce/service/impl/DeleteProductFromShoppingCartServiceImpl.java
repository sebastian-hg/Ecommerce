package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.exception.ShoppingCartNoExistException;
import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.repository.ProductRepository;
import com.mcdonalds.ecommerce.repository.ShoppingCartProductRepository;
import com.mcdonalds.ecommerce.repository.ShoppingCartRepository;
import com.mcdonalds.ecommerce.service.DeleteProductFromShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class DeleteProductFromShoppingCartServiceImpl implements DeleteProductFromShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartProductRepository shoppingCartProductRepository;
    private final ProductRepository productRepository;

    @Override
    public Mono<Boolean> execute(Long id, Long productId) {

        return Mono.just(shoppingCartRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(aBoolean -> shoppingCartProductRepository.findByShoppingCartIdAndProductId(id, productId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(shoppingCartProduct -> {
                    var items = shoppingCartProduct.getNumberOfProducts();
                    var shoppingCart = shoppingCartRepository.findById(id).orElseThrow();
                    var numberProduct = shoppingCart.getNumbersProduct() - items;
                    shoppingCart.setNumbersProduct(numberProduct);
                    var product = productRepository.findById(productId).orElseThrow();
                    var priceProduct = product.getPrice();
                    BigDecimal itemsBigDecimal = BigDecimal.valueOf(items);
                    var totalPurchase = itemsBigDecimal.multiply(priceProduct);
                    shoppingCart.setTotalPurchase(totalPurchase);
                    return shoppingCart;
                })
                .map(shoppingCartRepository::save)
                .flatMap(shoppingCart -> {
                    shoppingCartProductRepository.deleteByShoppingCartIdAndProductId(id, productId);
                    return null;
                })
                .map(shoppingCart -> Boolean.TRUE);
    }

}
