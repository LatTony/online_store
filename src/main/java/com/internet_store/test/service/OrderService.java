package com.internet_store.test.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import com.internet_store.test.entity.Order;
import com.internet_store.test.repository.OrderRepository;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}

