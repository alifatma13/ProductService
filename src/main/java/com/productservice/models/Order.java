package com.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.BitSet;
import java.util.List;

@Getter
@Setter
@Entity(name = "Orders")
public class Order extends BaseModel {

    /*------
        1                   M
        Order ---------- Product
        M                   1
     */
    @ManyToMany
    @JoinTable(name = "Products_orders", joinColumns = @JoinColumn(name = "Order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
