package  com.ayushbagaria.nearestrestaurant.connectivity;

import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface NearestRestaurantService {

  @GET("/task.txt")
  Call<ResponseBody> getResponse();


}
