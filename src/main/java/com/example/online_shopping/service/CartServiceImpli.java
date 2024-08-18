package com.example.online_shopping.service;

import com.example.online_shopping.model.Product;
import com.example.online_shopping.repository.Cart;
import com.example.online_shopping.repository.CartJPARepository;
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
    private CartJPARepository cartItems;

    @Getter
    int totalItems;

    @PostConstruct
    void init(){
        totalItems=0;
    }


    @Override
    public Product addToCart(Product prod) {
            cartItems.save(prod);
//            cartItems.save(cartItems.getTotalValue() + prod.getPrice());
            totalItems++;
            return prod;
    }

    @Override
    public List<Product> DisplayCartDetails() {
        return cartItems.findAll();
    }

    @Override
    public List<Product> getCartDetails() {
        return cartItems.findAll();
    }

//    @Override
//    public float getTotal(){
//        return cartItems.getTotalValue();
//    }

    @Override
    public Product findById(int id){
        List<Product> all = cartItems.findAll();
        return all.stream().filter(t->t.getProductID()==id).findFirst().orElse(null);
    }

    @Override
    public Product findByName(String productName) {
           return cartItems.findByproductName(productName);
    }

}
