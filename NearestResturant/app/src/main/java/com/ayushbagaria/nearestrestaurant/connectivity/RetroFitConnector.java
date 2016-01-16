package  com.ayushbagaria.nearestrestaurant.connectivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetroFitConnector {
  private static final String BASE_URL = "http://staging.couponapitest.com";
  private static final String LOG_TAG = RetroFitConnector.class.getSimpleName();
  private OkHttpClient httpClient;
  private Retrofit.Builder builder;

  public RetroFitConnector() {
    Gson gson = new GsonBuilder().create();
    httpClient = new OkHttpClient();
    builder = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson));
  }

  public <S> S createService(Class<S> serviceClass) {
    Retrofit retrofit = builder.client(httpClient).build();
    return retrofit.create(serviceClass);
  }
}
