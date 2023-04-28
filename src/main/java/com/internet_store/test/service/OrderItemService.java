package com.internet_store.test.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import com.internet_store.test.entity.OrderItem;
import com.internet_store.test.repository.OrderItemRepository;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

    public List<OrderItem> findByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}

