package com.productapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @Column(name="productid")
    @GeneratedValue (generator = "product_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_sequence",allocationSize = 1,initialValue = 1)
    private Integer productId;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String category;
    @Column(length = 40)
    private String brand;

    private double price;
}
