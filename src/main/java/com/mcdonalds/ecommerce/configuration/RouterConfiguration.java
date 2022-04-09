package com.mcdonalds.ecommerce.configuration;

import com.mcdonalds.ecommerce.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfiguration {
    @Bean
    public RouterFunction<ServerResponse> routeRequest(GetPurchaseByPersonHandler getPurchaseByPersonHandler,
                                                       CreateShoppingCartHandler createShoppingCartHandler,
                                                       DeleteShoppingCartHandler deleteShoppingCartHandler,
                                                       AddProductToShoppingCartHandler addProductToShoppingCartHandler,
                                                       DeleteProductFromShoppingCartHandler deleteProductFromShoppingCartHandler,
                                                       GetNumberProductsHandler getItemsFromShoppingCartHandler,
                                                       CheckOutShoppingCartHandler checkoutShoppingCartHandler,
                                                       GetShoppingCartByFilterHandler getShoppingCartByFilterHandler) {
        return route(RequestPredicates.GET("mcdonals/clients/{id}/purchases"), getPurchaseByPersonHandler::execute)
                .and(route(RequestPredicates.POST("mcdonalds/shopping-cart"),
                        createShoppingCartHandler::execute))
                .and(route(RequestPredicates.DELETE("mcdonalds/shopping-cart/{id}"),
                        deleteShoppingCartHandler::execute))
                .and(route(RequestPredicates.POST("mcdonalds/shopping-cart/{id}/product"),
                        addProductToShoppingCartHandler::execute))
                .and(route(RequestPredicates.DELETE("mcdonalds/shopping-cart/{shoppingCartId}/product/{productId}"),
                        deleteProductFromShoppingCartHandler::execute))
                .and(route(RequestPredicates.GET("mcdonalds/shopping-cart/{id}/items"),
                        getItemsFromShoppingCartHandler::execute))
                .and(route(RequestPredicates.PUT("mcdonals/shopping-cart/{id}/checkout"),
                        checkoutShoppingCartHandler::execute))
                .and(route(RequestPredicates.GET("mcdonalds/shopping-cart/client/{documentId}/creation-date/{init}/&/{end}/order/{typeOrder}"),
                        getShoppingCartByFilterHandler::execute));

    }
}
