package com.ayushbagaria.nearestrestaurant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable{
    @SerializedName("OfflineCategoryID")
    private String offlineCategoryID;
    @SerializedName("Name")
    private String name;
    @SerializedName("ParentCategoryID")
    private String parentCategoryID;
    @SerializedName("CategoryType")
    private String categoryType;

    public String getOfflineCategoryID() {
        return offlineCategoryID;
    }

    public void setOfflineCategoryID(String offlineCategoryID) {
        this.offlineCategoryID = offlineCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCategoryID() {
        return parentCategoryID;
    }

    public void setParentCategoryID(String parentCategoryID) {
        this.parentCategoryID = parentCategoryID;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public static Creator<Category> getCREATOR() {
        return CREATOR;
    }



    protected Category(Parcel in) {
        offlineCategoryID = in.readString();
        name = in.readString();
        parentCategoryID = in.readString();
        categoryType = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(offlineCategoryID);
        dest.writeString(name);
        dest.writeString(parentCategoryID);
        dest.writeString(categoryType);
    }

}
