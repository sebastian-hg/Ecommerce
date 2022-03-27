package com.mcdonalds.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class Product {
    @Id
    private Long id;
    private String description;
    private Size size;
}
