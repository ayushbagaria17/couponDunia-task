package com.ayushbagaria.nearestrestaurant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Status implements Parcelable{
    @SerializedName("rcode")
    private String rcode;
    @SerializedName("message")
    private String message;

    protected Status(Parcel in) {
        rcode = in.readString();
        message = in.readString();
    }

    public static final Creator<Status> CREATOR = new Creator<Status>() {
        @Override
        public Status createFromParcel(Parcel in) {
            return new Status(in);
        }

        @Override
        public Status[] newArray(int size) {
            return new Status[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rcode);
        dest.writeString(message);
    }
}
