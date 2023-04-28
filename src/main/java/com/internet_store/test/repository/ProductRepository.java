package com.internet_store.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.internet_store.test.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

