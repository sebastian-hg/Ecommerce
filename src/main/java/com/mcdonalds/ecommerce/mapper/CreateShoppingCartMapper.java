package com.mcdonalds.ecommerce.mapper;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.model.dto.response.CreateShoppingCartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateShoppingCartMapper {

//    @Mapping(target = "nameCompleted", expression = "java(shoppingCart)")
   // @Mapping(target = "nationalId", expression = "java(shoppingCart.getClient().getDocumentNational)")
    CreateShoppingCartResponse toResponseDto(ShoppingCart shoppingCart);

}
