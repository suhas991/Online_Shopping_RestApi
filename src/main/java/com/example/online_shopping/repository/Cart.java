package com.example.online_shopping.repository;

import com.example.online_shopping.model.Product;

import java.util.*;

public interface Cart {
    public List<Product> getProduct();
    public Product setProduct(Product prod);
    public float getTotalValue();
    public void setTotalValue(float total);
}
