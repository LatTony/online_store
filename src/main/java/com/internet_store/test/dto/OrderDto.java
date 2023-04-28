package com.internet_store.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private LocalDateTime orderDate;
    private String orderStatus;
    private Double totalPrice;
    private UserDto user;
    private List<OrderItemDto> orderItems;
}
