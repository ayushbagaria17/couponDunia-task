package com.ayushbagaria.nearestrestaurant.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayushbagaria.nearestrestaurant.R;
import com.ayushbagaria.nearestrestaurant.holder.RestaurantListHolder;
import com.ayushbagaria.nearestrestaurant.model.Category;
import com.ayushbagaria.nearestrestaurant.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class NearestRestaurantRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private List<Restaurant> restaurantList = new ArrayList<>();
    private Context context;

    public NearestRestaurantRecyclerAdapter(Context context) {
            this.context = context;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }

    public void addRestaurantList(List<Restaurant> restaurantList) {
            this.restaurantList.clear();
            this.restaurantList.addAll(restaurantList);
            notifyDataSetChanged();
            }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View cardView;
            RecyclerView.ViewHolder baseViewHolder;
            cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            baseViewHolder = new RestaurantListHolder(cardView);
            return baseViewHolder;
            }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
            RestaurantListHolder holder = (RestaurantListHolder) viewHolder;
            final Restaurant restaurant = restaurantList.get(position);
            holder.tv_rest_name.setText(restaurant.getOutletName());
            holder.tv_area.setText(restaurant.getNeighbourhoodName());
            holder.tv_offercnt.setText(Integer.toString(restaurant.getNumCoupons()));
            holder.tv_offercnt_label.setText(restaurant.getNumCoupons() > 1 ? R.string.offers : R.string.offer);
            Picasso.with(context)
                    .load(restaurant.getLogoURL())
                    .into(holder.img_logo);
            holder.tv_category.setText(getCategoryString(restaurant.getCategories()));
            holder.tv_distance.setText(Integer.toString((int) restaurant.getDistanceBtwnPoints()) + " m");
            }

    private String getCategoryString(List<Category> categories) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i< categories.size(); i++) {
            s.append( Html.fromHtml("&#8226"));
            s.append(categories.get(i).getName());
            s.append(" ");
        }
        return s.toString();
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


    public List<Restaurant> getRestaurantList() {
            return restaurantList;
           }
}
