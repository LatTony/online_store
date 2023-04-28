package com.internet_store.test.mapper;

import com.internet_store.test.dto.UserDto;
import com.internet_store.test.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
