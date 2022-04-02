package com.mcdonalds.ecommerce.repository;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query(value = "SELECT c.total_purchase FROM shopping_cart c WHERE c.client=?1 and c.creation_date=?2 BETWEEN ?3 AND ?4"
            , nativeQuery = true)
    Double searchShoppingCartByDate(Long cryptoId, LocalDateTime star);
}
