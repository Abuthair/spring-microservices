package com.cart.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private Integer productId;
    private String name;
    private String category;
    private String brand;

    private double price;
}
