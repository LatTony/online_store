package com.internet_store.test.mapper;

import com.internet_store.test.dto.ProductDto;
import com.internet_store.test.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);
}

