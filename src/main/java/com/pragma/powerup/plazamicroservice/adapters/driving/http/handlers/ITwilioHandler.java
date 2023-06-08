package com.pragma.powerup.plazamicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.plazamicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITwilioHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto, String authorizationHeader);

    void addEmployeeToRestaurant(UserRequestDto userRequestDto, String token);

    List<RestaurantNewResponseDto> getAllRestaurants(Pageable pageable);
}
