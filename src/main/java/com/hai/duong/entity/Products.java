package com.hai.duong.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "inStock")
    private int inStock;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "descriptions",columnDefinition = "text")
    private String descriptions;

    @Column(name = "status")
    private boolean status;

    @ManyToMany(mappedBy = "products")
    @EqualsAndHashCode.Exclude
    private Collection<Order> orders;

}
