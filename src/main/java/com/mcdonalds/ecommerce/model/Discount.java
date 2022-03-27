package com.mcdonalds.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class Discount {
    private Long id;
    private String name;
    private String description;
    private Integer totalDiscount;

}
