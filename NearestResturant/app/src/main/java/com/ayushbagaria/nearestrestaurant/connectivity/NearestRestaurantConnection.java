package  com.ayushbagaria.nearestrestaurant.connectivity;

import android.content.Context;
import android.util.Log;

import com.ayushbagaria.nearestrestaurant.common.JsonConverter;
import com.ayushbagaria.nearestrestaurant.listener.ResultCallBack;
import com.ayushbagaria.nearestrestaurant.model.RestaurantResponse;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class NearestRestaurantConnection {

  private static final String LOG_TAG = NearestRestaurantConnection.class.getSimpleName();
  private RetroFitConnector retroFitConnector;


  public NearestRestaurantConnection(Context context) {
    retroFitConnector = new RetroFitConnector();
  }

  public void getResponse(final ResultCallBack<RestaurantResponse> resultCallBack) {
    NearestRestaurantService service = retroFitConnector.createService(NearestRestaurantService.class);
    Call<ResponseBody> request = service.getResponse();
    request.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
        if (response.isSuccess()) {
          String responseString = "";
          try {
            responseString = response.body().string();
          } catch (Exception e) {
            Log.e(LOG_TAG, Log.getStackTraceString(e));
          }

          RestaurantResponse restaurantResponse = new JsonConverter().fromJson(responseString, new TypeToken<RestaurantResponse>() {
          }.getType());
          resultCallBack.onResultCallBack(restaurantResponse, null);
        } else {
          resultCallBack.onResultCallBack(null, new Exception());
        }
      }

      @Override
      public void onFailure(Throwable t) {
        t.printStackTrace(System.err);
        resultCallBack.onResultCallBack(null, new Exception());
      }
    });
  }
}