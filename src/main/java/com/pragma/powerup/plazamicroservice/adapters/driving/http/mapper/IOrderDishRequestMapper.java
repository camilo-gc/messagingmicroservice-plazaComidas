package com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderDishRequestMapper {

    @Mapping(target = "dish.id", source = "idDish")
    OrderDish toOrderDish(OrderDishRequestDto orderDishRequestDto);

    List<OrderDish> toOrderDishList(List<OrderDishRequestDto> orderDishRequestDtoList);

}
