package com.internet_store.test.service;

import com.internet_store.test.dto.OrderDto;
import com.internet_store.test.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.internet_store.test.entity.Order;
import com.internet_store.test.repository.OrderRepository;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.fromDto(orderDto);
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
        return orderMapper.toDto(order);
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
