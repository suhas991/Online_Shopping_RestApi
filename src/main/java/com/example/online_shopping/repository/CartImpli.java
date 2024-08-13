package com.example.online_shopping.repository;

import com.example.online_shopping.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartImpli implements Cart {

    private List<Product> products;
    private float totalVal;

    @PostConstruct
    void init(){
        products = new ArrayList<>();
        totalVal=0;
    }

    @Override
    public List<Product> getProduct() {
        return products;
    }

    @Override
    public Product setProduct(Product prod) {
          products.add(prod);
          return prod;
    }

    @Override
    public float getTotalValue() {
        return totalVal;
    }

    @Override
    public void setTotalValue(float total) {
        this.totalVal = total;
    }
}
