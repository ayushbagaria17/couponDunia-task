package com.ayushbagaria.nearestrestaurant.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayushbagaria.nearestrestaurant.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantListHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.img_logo)
    public ImageView img_logo;
    @Bind(R.id.img_heart)
    public ImageView img_heart;
    @Bind(R.id.tv_rest_name)
    public TextView tv_rest_name;
    @Bind(R.id.tv_area)
    public TextView tv_area;
    @Bind(R.id.tv_distance)
    public TextView tv_distance;
    @Bind(R.id.tv_category)
    public TextView tv_category;
    @Bind(R.id.tv_offercnt)
    public TextView tv_offercnt;
    @Bind(R.id.tv_offercnt_label)
    public TextView tv_offercnt_label;

    public RestaurantListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
