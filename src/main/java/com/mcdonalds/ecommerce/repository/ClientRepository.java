package com.mcdonalds.ecommerce.repository;

import com.mcdonalds.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
