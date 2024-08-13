package com.example.online_shopping.service;

import com.example.online_shopping.model.Product;
import com.example.online_shopping.repository.Cart;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpli implements CartService{

    @Autowired
    private Cart cartItems;

    @Getter
    int totalItems;

    @PostConstruct
    void init(){
        totalItems=0;
    }

    public Cart getCart(){
         return cartItems;
    }

    @Override
    public Product addToCart(Product prod) {
            cartItems.setProduct(prod);
            cartItems.setTotalValue(cartItems.getTotalValue() + prod.getPrice());
            totalItems++;
            return prod;
    }

    @Override
    public List<Product> DisplayCartDetails() {
        return cartItems.getProduct();
    }

    @Override
    public Cart getCartDetails() {
        return cartItems;
    }

    @Override
    public float getTotal(){
        return cartItems.getTotalValue();
    }

    @Override
    public Product findById(int id){
        List<Product> all = cartItems.getProduct();
        return all.stream().filter(t->t.getProductID()==id).findFirst().orElse(null);
    }
}
