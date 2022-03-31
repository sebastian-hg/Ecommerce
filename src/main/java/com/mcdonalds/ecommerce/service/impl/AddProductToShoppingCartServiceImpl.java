package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.exception.ProductNoAvailableExistException;
import com.mcdonalds.ecommerce.mapper.AddProductShoppingCartMapper;
import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.model.ShoppingCartProduct;
import com.mcdonalds.ecommerce.model.dto.request.AddProductRequest;
import com.mcdonalds.ecommerce.repository.ClientRepository;
import com.mcdonalds.ecommerce.repository.ProductRepository;
import com.mcdonalds.ecommerce.repository.ShoppingCartProductRepository;
import com.mcdonalds.ecommerce.repository.ShoppingCartRepository;
import com.mcdonalds.ecommerce.service.AddProductToShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class AddProductToShoppingCartServiceImpl implements AddProductToShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final AddProductShoppingCartMapper mapper;
    private final ShoppingCartProductRepository shoppingCartProductRepository;


    @Override
    public Mono<ShoppingCart> execute(Long id, AddProductRequest addProductRequest) {
        return Mono.just(addProductRequest)
                .map(addProductRequest1 -> shoppingCartRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(shoppingCart -> {
                    var product = productRepository.findById(addProductRequest.getProductId())
                            .orElseThrow();
                    var detail = ShoppingCartProduct.builder()
                            .product(product)
                            .numberOfProducts(addProductRequest.getNumberOfProduct())
                            .build();
                    //TODO: AGREGAR VALIDACION DE NUMBERO DE PRODUCTOS, SI YA EXISTE EL PRODUCTO EN LE CARRO
                    shoppingCartProductRepository.save(detail);
                    var newProducts = detail.getNumberOfProducts() + shoppingCart.getNumbersProduct();
                    shoppingCart.setNumbersProduct(newProducts);

                    return shoppingCart;
                })
                .map(shoppingCartRepository::save)
                .switchIfEmpty(Mono.error(ProductNoAvailableExistException::new));
    }
}
