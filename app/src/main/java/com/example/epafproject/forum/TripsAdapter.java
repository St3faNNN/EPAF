package com.example.epafproject.forum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epafproject.R;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<com.example.epafproject.forum.TripsAdapter.ViewHolder>{
    private List<Trips> postsTrips;

    Context mContext;

    String adress;

    Bitmap decodedImage;

    private ArrayList<Trips> trips = new ArrayList<>();

    public TripsAdapter(List<Trips> postsTrips, Context mContext) {
        this.postsTrips = postsTrips;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public com.example.epafproject.forum.TripsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_trips, parent, false);
        return new TripsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.epafproject.forum.TripsAdapter.ViewHolder holder, int position) {

//        holder.tvLat.setText(postsList.get(position).getLat());
//        holder.tvLon.setText(postsList.get(position).getLon());

        holder.tvDesc.setText(postsTrips.get(position).getDescription());

        holder.tvTitle.setText(postsTrips.get(position).getTitle());
        holder.tvUser.setText(postsTrips.get(position).getSendFrom());

//        decode image
        byte[] imageBytes = Base64.decode(postsTrips.get(position).getEncodedImg(), Base64.DEFAULT);
        decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        holder.tvImage.setImageBitmap(decodedImage);


        //address
        double lat = Double.parseDouble(postsTrips.get(position).getLat());
        double lon = Double.parseDouble(postsTrips.get(position).getLon());

        Geocoder geocoder = new Geocoder(mContext);
        try {
            List<Address> addressList = geocoder.getFromLocation(lat, lon, 1);
            if (addressList != null && addressList.size() > 0) {
                // Help here to get only the street name
                adress = addressList.get(0).getAddressLine(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.tvAddress.setText(adress);


    }

    @Override
    public int getItemCount() {
        return postsTrips.size();
    }


    public Trips getItem(int position) {
        return postsTrips.get(position);
    }

    class ViewHolder  extends RecyclerView.ViewHolder{

        ImageView tvImage;
        TextView tvLat, tvLon, tvDesc, tvAddress, tvTitle, tvUser;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);

            tvTitle = itemView.findViewById(R.id.txtTitleTrip);
            tvUser = itemView.findViewById(R.id.txtSendFromTrip);

//            tvLat = itemView.findViewById(R.id.txtLat);
//            tvLon = itemView.findViewById(R.id.txtLon);
            tvDesc = itemView.findViewById(R.id.txtDescTrip);
            tvImage = itemView.findViewById(R.id.imgEventTrip);

            tvAddress = itemView.findViewById(R.id.txtAddressTrip);
        }
    }
}
