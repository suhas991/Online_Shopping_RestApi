package com.example.online_shopping.service;

import com.example.online_shopping.model.Product;
import com.example.online_shopping.repository.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
      public Product addToCart(Product prod);
      public List<Product> DisplayCartDetails();
      public Cart getCartDetails();
      public float getTotal();
      public Product findById(int id);
}
