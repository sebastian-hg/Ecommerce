package com.mcdonalds.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class ShoppingCart {
    @Id
    private Long id;
    private Client client;
    private List<Product> productList;
    private List<Discount> discountList;
    private LocalDate date;
    private Time time;
    private Boolean vip;
    private Integer status;
    private Integer amountTotal;


}
