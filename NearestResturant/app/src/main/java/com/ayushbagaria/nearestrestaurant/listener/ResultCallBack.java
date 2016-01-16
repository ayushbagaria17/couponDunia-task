package com.ayushbagaria.nearestrestaurant.listener;

public interface ResultCallBack<T> {
  void onResultCallBack(T object, Exception e);
}
