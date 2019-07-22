package com.example.week7weekend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.week7weekend.randomme.Result;

import java.util.List;
import java.util.Locale;


public class RandomMeRVAdapter
        extends RecyclerView.Adapter<RandomMeRVAdapter.ViewHolder> {
    List<Result> listOfResults;

    public RandomMeRVAdapter(List<Result> listOfResults) {
        this.listOfResults = listOfResults;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.random_me_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result itemResult = listOfResults.get(position);

        final String imageURL = itemResult.getPicture().getThumbnail();

        Glide
                .with(holder.imgRandomUserPic)
                .load(imageURL)
                .into(holder.imgRandomUserPic);
    }

    @Override
    public int getItemCount() {
        return listOfResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRandomUserPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRandomUserPic = itemView.findViewById(R.id.imgRandomUserImage);

        }
    }
}
