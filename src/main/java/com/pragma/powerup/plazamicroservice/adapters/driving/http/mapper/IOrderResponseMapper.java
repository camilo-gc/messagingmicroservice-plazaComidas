package com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderResponseMapper {

    @Mapping(target = "idClient", source = "idClient")
    @Mapping(target = "idChef", source = "chef.idEmployee")
    @Mapping(target = "idRestaurant", source = "restaurant.id")
    OrderResponseDto toResponse(Order order);

    List<OrderResponseDto> toResponseList(List<Order> orderList);

}
