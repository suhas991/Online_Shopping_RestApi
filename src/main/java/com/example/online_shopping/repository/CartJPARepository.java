package com.example.online_shopping.repository;


import com.example.online_shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJPARepository extends JpaRepository<Product,Integer> {

    Product findByproductName(String productName);
}
