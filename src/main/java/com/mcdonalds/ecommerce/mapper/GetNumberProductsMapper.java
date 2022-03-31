package com.mcdonalds.ecommerce.mapper;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.model.dto.response.GetNumberProductsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetNumberProductsMapper {
    GetNumberProductsResponse toResponseDto(ShoppingCart shoppingCart);
}
