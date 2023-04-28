package com.internet_store.test.service;

import com.internet_store.test.dto.OrderItemDto;
import com.internet_store.test.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.internet_store.test.entity.OrderItem;
import com.internet_store.test.repository.OrderItemRepository;

@Service
@AllArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemMapper.fromDto(orderItemDto);
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    public OrderItemDto getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("OrderItem not found"));
        return orderItemMapper.toDto(orderItem);
    }

    public List<OrderItemDto> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream().map(orderItemMapper::toDto).collect(Collectors.toList());
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
