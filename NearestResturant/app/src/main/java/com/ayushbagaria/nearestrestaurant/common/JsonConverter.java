package com.ayushbagaria.nearestrestaurant.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JsonConverter {
  private final Gson gson;

  public JsonConverter() {
    gson = new GsonBuilder().create();
  }

  public String toJson(Object object) {
    return gson.toJson(object);
  }

  public <T> T fromJson(String s, Class<T> classOfT) {
    return gson.fromJson(s, classOfT);
  }

  public <T> T fromJson(String json, Type typeOfT) {
    return gson.fromJson(json, typeOfT);
  }
}
