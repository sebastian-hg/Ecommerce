package com.mcdonalds.ecommerce.repository;

import com.mcdonalds.ecommerce.model.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Long> {
    Optional<ShoppingCartProduct> findByShoppingCartIdAndProductId(Long shoppingCardId, Long productId);

    void deleteByShoppingCartIdAndProductId(Long shoppingCardId, Long productId);
}
