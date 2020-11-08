package com.hai.duong.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CollectionId;

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
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users users;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "Order_detail",
            joinColumns = @JoinColumn(name = "orderID"),
            inverseJoinColumns = @JoinColumn(name = "productID")
    )
    private Collection<Products> products;

}