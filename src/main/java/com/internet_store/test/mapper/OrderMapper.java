package com.internet_store.test.mapper;

import com.internet_store.test.dto.OrderDto;
import com.internet_store.test.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(Order order);

    Order fromDto(OrderDto orderDto);
}

