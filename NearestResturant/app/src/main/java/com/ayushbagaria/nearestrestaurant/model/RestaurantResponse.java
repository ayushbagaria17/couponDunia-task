package com.ayushbagaria.nearestrestaurant.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantResponse {
    @SerializedName("status")
    private  Status status;
    @SerializedName("data")
    private List<Restaurant> restaurantList;
    @SerializedName("hash")
    private  String hash;

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }
}
