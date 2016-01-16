package com.ayushbagaria.nearestrestaurant;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ayushbagaria.nearestrestaurant.adapter.NearestRestaurantRecyclerAdapter;
import com.ayushbagaria.nearestrestaurant.connectivity.NearestRestaurantConnection;
import com.ayushbagaria.nearestrestaurant.listener.ResultCallBack;
import com.ayushbagaria.nearestrestaurant.model.Restaurant;
import com.ayushbagaria.nearestrestaurant.model.RestaurantResponse;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_list)
    RecyclerView recyclerView;
    @Bind(R.id.tv_area_name)
    TextView tv_area_name;

    NearestRestaurantRecyclerAdapter adapter;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    GoogleApiClient mGoogleApiClient;
    private List<Restaurant> tempList = new ArrayList<>();
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    double latitude;
    double longitude;
    NearestRestaurantConnection  nearestRestaurantConnection;
    Geocoder geocoder;

    private ResultCallBack<RestaurantResponse> allRestaurantResponseListenerResultCallback = new ResultCallBack<RestaurantResponse>() {
        @Override
        public void onResultCallBack(final RestaurantResponse restaurantResponse, Exception e) {
            for(Restaurant restaurant: restaurantResponse.getRestaurantList()){
                Location restLocation = new Location("RestLocation");
                restLocation.setLatitude(Double.parseDouble(restaurant.getLatitude()));
                restLocation.setLongitude(Double.parseDouble(restaurant.getLongitude()));
                restaurant.setDistanceBtwnPoints(mLastLocation.distanceTo(restLocation)); 
                tempList.add(restaurant);
            }
            updateList();
        }

    };

    private void updateList() {
        sortlist();
        adapter.addRestaurantList(tempList);
    }

    private void sortlist() {
        Collections.sort(tempList, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant lhs, Restaurant rhs) {
                return (int)(lhs.getDistanceBtwnPoints() - rhs.getDistanceBtwnPoints());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.title);
        }
        nearestRestaurantConnection= new NearestRestaurantConnection(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new NearestRestaurantRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        buildGoogleApiClient();
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }

    private void getLocation() throws IOException {
        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
            setlocatity();
            nearestRestaurantConnection.getResponse(allRestaurantResponseListenerResultCallback);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Couldn't get the location. Make sure location is enabled on the device", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void setlocatity() throws IOException {
        geocoder =  new Geocoder(this, Locale.getDefault());
        List<Address> address =  geocoder.getFromLocation(latitude, longitude, 1);
        tv_area_name.setText(address.get(0).getAddressLine(1));
    }

    @Override
    public void onConnected(Bundle bundle) {
        try {
            getLocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("ERROR", "Connection failed: ConnectionResult.getErrorCode() = "
                + connectionResult.getErrorCode());
    }
}
