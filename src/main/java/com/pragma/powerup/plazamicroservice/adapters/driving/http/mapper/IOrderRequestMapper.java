package com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderRequestMapper {

    @Mapping(target = "restaurant.id", source = "idRestaurant")
    Order toOrder(OrderRequestDto orderRequestDto);

}