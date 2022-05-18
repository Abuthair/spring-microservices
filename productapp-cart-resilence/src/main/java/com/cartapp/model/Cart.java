package com.cartapp.model;

import lombok.*;

import java.util.List;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Cart {
        int cartId;
        List<Product> products;
        double totalcost;


    }
