package com.internet_store.test.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import com.internet_store.test.entity.Order;
import com.internet_store.test.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> findByUserId(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }
}