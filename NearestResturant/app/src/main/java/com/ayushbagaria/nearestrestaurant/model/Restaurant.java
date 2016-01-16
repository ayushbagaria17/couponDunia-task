package com.ayushbagaria.nearestrestaurant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant implements Parcelable{
    @SerializedName("SubFranchiseID")
    private String subFranchiseID;
    @SerializedName("OutletID")
    private String outletID;
    @SerializedName("OutletName")
    private String outletName;
    @SerializedName("BrandID")
    private String brandID;
    @SerializedName("Address")
    private String address;
    @SerializedName("NeighbourhoodID")
    private String neighbourhoodID;
    @SerializedName("CityID")
    private String cityID;
    @SerializedName("Email")
    private String email;
    @SerializedName("Timings")
    private String timings;
    @SerializedName("CityRank")
    private String cityRank;
    @SerializedName("Latitude")
    private String latitude;
    @SerializedName("Longitude")
    private String longitude;
    @SerializedName("Pincode")
    private String pincode;
    @SerializedName("Landmark")
    private String landmark;
    @SerializedName("Streetname")
    private String streetname;
    @SerializedName("BrandName")
    private String brandName;
    @SerializedName("OutletURL")
    private String outletURL;
    @SerializedName("NumCoupons")
    private int numCoupons;
    @SerializedName("NeighbourhoodName")
    private String neighbourhoodName;
    @SerializedName("PhoneNumber")
    private String phoneNumber;
    @SerializedName("CityName")
    private String cityName;
    @SerializedName("Distance")
    private double distance;
    @SerializedName("Categories")
    List<Category> categories;
    @SerializedName("LogoURL")
    private String logoURL;
    @SerializedName("CoverURL")
    private String coverURL;
    @SerializedName("distanceBtwnPoints")
    private double distanceBtwnPoints;

    public double getDistanceBtwnPoints() {
        return distanceBtwnPoints;
    }

    public void setDistanceBtwnPoints(double distanceBtwnPoints) {
        this.distanceBtwnPoints = distanceBtwnPoints;
    }

    public String getSubFranchiseID() {
        return subFranchiseID;
    }

    public void setSubFranchiseID(String subFranchiseID) {
        this.subFranchiseID = subFranchiseID;
    }

    public String getOutletID() {
        return outletID;
    }

    public void setOutletID(String outletID) {
        this.outletID = outletID;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighbourhoodID() {
        return neighbourhoodID;
    }

    public void setNeighbourhoodID(String neighbourhoodID) {
        this.neighbourhoodID = neighbourhoodID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getCityRank() {
        return cityRank;
    }

    public void setCityRank(String cityRank) {
        this.cityRank = cityRank;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOutletURL() {
        return outletURL;
    }

    public void setOutletURL(String outletURL) {
        this.outletURL = outletURL;
    }

    public int getNumCoupons() {
        return numCoupons;
    }

    public void setNumCoupons(int numCoupons) {
        this.numCoupons = numCoupons;
    }

    public String getNeighbourhoodName() {
        return neighbourhoodName;
    }

    public void setNeighbourhoodName(String neighbourhoodName) {
        this.neighbourhoodName = neighbourhoodName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public static Creator<Restaurant> getCREATOR() {
        return CREATOR;
    }

    protected Restaurant(Parcel in) {
        subFranchiseID = in.readString();
        outletID = in.readString();
        outletName = in.readString();
        brandID = in.readString();
        address = in.readString();
        neighbourhoodID = in.readString();
        cityID = in.readString();
        email = in.readString();
        timings = in.readString();
        cityRank = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        pincode = in.readString();
        landmark = in.readString();
        streetname = in.readString();
        brandName = in.readString();
        outletURL = in.readString();
        numCoupons = in.readInt();
        neighbourhoodName = in.readString();
        phoneNumber = in.readString();
        cityName = in.readString();
        distance = in.readDouble();
        in.readTypedList(categories, Category.CREATOR);
        logoURL = in.readString();
        coverURL = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subFranchiseID);
        dest.writeString(outletID);
        dest.writeString(outletName);
        dest.writeString(brandID);
        dest.writeString(address);
        dest.writeString(neighbourhoodID);
        dest.writeString(cityID);
        dest.writeString(email);
        dest.writeString(timings);
        dest.writeString(cityRank);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(pincode);
        dest.writeString(landmark);
        dest.writeString(streetname);
        dest.writeString(brandName);
        dest.writeString(outletURL);
        dest.writeInt(numCoupons);
        dest.writeString(neighbourhoodName);
        dest.writeString(phoneNumber);
        dest.writeString(cityName);
        dest.writeDouble(distance);
        dest.writeTypedList(categories);
        dest.writeString(logoURL);
        dest.writeString(coverURL);
    }
}
