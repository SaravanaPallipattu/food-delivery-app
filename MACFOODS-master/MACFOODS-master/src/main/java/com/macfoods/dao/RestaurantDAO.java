package com.macfoods.dao;

import java.util.List;

import com.macfoods.dto.Restaurant;


public interface RestaurantDAO {
	List<Restaurant> getRestaurants();
	Restaurant getRestaurantByID(int userId);
	int insertRestaurant(Restaurant rest);
	int updateRestaurantById(int userId,float ratings);
	int deleteRestaurantByID(int id);
	List<Restaurant> getRestaurantsByLocation(String cityName);
	List<Restaurant> getTopRestaurants(String cityName);
	
}
