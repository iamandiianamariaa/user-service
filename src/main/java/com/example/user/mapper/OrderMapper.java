package com.example.user.mapper;

import com.example.user.dto.OrderDto;
import com.example.user.dto.OrderRequestDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OrderMapper {
    OrderRequestDto mapToRequestDto(OrderDto orderDto);
}
