package com.internet_store.test.mapper;

import com.internet_store.test.dto.OrderItemDto;
import com.internet_store.test.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemDto toDto(OrderItem orderItem);

    OrderItem fromDto(OrderItemDto orderItemDto);
}

