package com.mcdonalds.ecommerce.repository;

import com.mcdonalds.ecommerce.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
