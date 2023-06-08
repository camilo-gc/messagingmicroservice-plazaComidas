package com.pragma.powerup.plazamicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.plazamicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper.IRestaurantResponseMapper;
import com.pragma.powerup.plazamicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TwilioHandlerImpl implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;
    private final IUserRequestMapper userRequestMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto, String authorizationHeader) {
        restaurantServicePort.saveRestaurant( restaurantRequestMapper.toRestaurant( restaurantRequestDto ), authorizationHeader );
    }

    @Override
    public void addEmployeeToRestaurant(UserRequestDto userRequestDto, String token) {
        restaurantServicePort.addEmployeeToRestaurant(
                Long.valueOf(userRequestDto.getId_restaurant()),
                userRequestMapper.toUser( userRequestDto ),
                token
        );
    }

    @Override
    public List<RestaurantNewResponseDto> getAllRestaurants(Pageable pageable) {
        return restaurantResponseMapper.toNewResponseList( restaurantServicePort.getAllRestaurants(pageable) );
    }

}
