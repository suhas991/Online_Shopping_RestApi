package com.example.online_shopping.api;

import com.example.online_shopping.model.Product;
import com.example.online_shopping.repository.Cart;
import com.example.online_shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

       @Autowired
       private CartService cartService;

       @GetMapping
       @ResponseStatus(HttpStatus.OK)
       public List<Product> DisplayCart(){
           return cartService.DisplayCartDetails();
       }

       @PostMapping
       @ResponseStatus(HttpStatus.CREATED)
       public Product addToCart(@RequestBody Product prod){
           return cartService.addToCart(prod);
       }

       @GetMapping("/cart")
       @ResponseStatus(HttpStatus.OK)
       public Cart GetCartItems(){
              return cartService.getCartDetails();
       }

       @GetMapping("/total")
       @ResponseStatus(HttpStatus.OK)
       public float totalPrice(){
              return cartService.getTotal();
       }

       @GetMapping("/{id}")
       @ResponseStatus(HttpStatus.OK)
       public Product getById(@PathVariable int id){
              return cartService.findById(id);
       }


}
