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
public class Price {
    @Id
    private Long id;
    private Integer amount;
}