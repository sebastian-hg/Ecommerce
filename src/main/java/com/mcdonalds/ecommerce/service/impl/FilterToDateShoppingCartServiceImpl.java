package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.repository.ClientRepository;
import com.mcdonalds.ecommerce.repository.ShoppingCartRepository;
import com.mcdonalds.ecommerce.service.FilterToDateShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Service
public class FilterToDateShoppingCartServiceImpl implements FilterToDateShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ClientRepository clientRepository;

    @Override
    public Mono<ShoppingCart> execute(Integer documentId) {
        Mono.just(clientRepository.findByDocumentNational(documentId).orElseThrow());
        return null;

    }
}
