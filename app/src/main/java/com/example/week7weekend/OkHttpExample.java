package com.example.week7weekend;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week7weekend.randomme.RandomMeResponse;
import com.google.gson.Gson;



import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpExample {


    public void getSyncResponse(Context context){
        OkHttpClient returnClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://randomuser.me/api/?results=5").build();

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Response response = returnClient.newCall(request).execute();
                        Gson gson = new Gson();
                        RandomMeResponse randomMeResponse =
                                gson.fromJson(response.body().string(), RandomMeResponse.class);
                        ((MainActivity)context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                RecyclerView rvRandomUserRecyclerView=((MainActivity)context).findViewById(R.id.rvRandomMeList);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                                RandomMeRVAdapter adapter = new RandomMeRVAdapter(randomMeResponse.getResults());
                                rvRandomUserRecyclerView.setLayoutManager(layoutManager);
                                rvRandomUserRecyclerView.setAdapter(adapter);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });



           thread.start();

    }
}
