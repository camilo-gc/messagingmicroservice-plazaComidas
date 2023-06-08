package com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderUpdateRequestMapper {

    Order toOrder(OrderUpdateRequestDto orderUpdateRequestDto);

    List<Order> toOrderList(List<OrderUpdateRequestDto> orderUpdateRequestDtoList);

}