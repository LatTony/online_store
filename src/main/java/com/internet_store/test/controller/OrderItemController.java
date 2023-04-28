package com.internet_store.test.controller;

import com.internet_store.test.dto.OrderItemDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import com.internet_store.test.service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
@AllArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemDto orderItemDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItemService.createOrderItem(orderItemDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        return ResponseEntity.ok(orderItemService.getAllOrderItems());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}