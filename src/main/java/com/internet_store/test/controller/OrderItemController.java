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
import com.internet_store.test.entity.OrderItem;
import com.internet_store.test.service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
@AllArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> findAll() {
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
    public OrderItem findById(@PathVariable Long id) {
        return orderItemService.findById(id).orElseThrow(() -> new IllegalArgumentException("Order item not found"));
    }

    @PostMapping
    public OrderItem save(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderItemService.deleteById(id);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItem> findByOrderId(@PathVariable Long orderId) {
        return orderItemService.findByOrderId(orderId);
    }
}

