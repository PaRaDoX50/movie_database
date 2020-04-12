package com.example.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity {
    String url = "https://api.themoviedb.org/3/discover/movie?api_key=c604ddb180c79f41f9d9a4faf4b59c03&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Button button2 = findViewById(R.id.button2);
        final ArrayList<FeedData> dataForfeed = new ArrayList<>();

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    final JSONObject object = ApiResponse.method(getApplicationContext());
                    JSONArray array = object.getJSONArray("results");
                    for(int i =0; i < array.length();i++){
                        JSONObject obj2 = array.getJSONObject(i);
                        String title = obj2.getString("title");
                        String img = obj2.getString("poster_path");
                        String overview = obj2.getString("overview");
                        dataForfeed.add(new FeedData(title,img,overview));
                    }
                    FeedAdap feedAdap = new FeedAdap(getApplicationContext(),dataForfeed);
                    RecyclerView recyclerView = findViewById(R.id.recyclerview_feed);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(feedAdap);
                    Log.d("hello", "onCreate: " + object.toString());










                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON: \""  + "\"");
                }


            }
        });









    }
}
