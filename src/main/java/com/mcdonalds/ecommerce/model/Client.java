package com.mcdonalds.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id = 0L;
    private Integer documentNational;
    private String nameCompleted;
    @ManyToMany
    private List<Discount> nextDiscount;
}
