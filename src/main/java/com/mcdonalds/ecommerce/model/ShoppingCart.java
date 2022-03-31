package com.mcdonalds.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id = 0L;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Discount> discounts;
    @Builder.Default
    private LocalDate creationDate = LocalDate.now();
    @Builder.Default
    private LocalTime creationTime = LocalTime.now();
    private Boolean isVip;
    @Builder.Default
    private Integer numbersProduct = 0;
    @Builder.Default
    private BigDecimal totalPurchase = BigDecimal.ZERO;
}
