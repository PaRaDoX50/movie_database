package com.example.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class aboutMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_movie);
        String title = getIntent().getStringExtra("title");
        String img = getIntent().getStringExtra("img");
        String overview = getIntent().getStringExtra("overview");
        TextView t = findViewById(R.id.movie_title1);
        t.setText(title);
        ImageView i = findViewById(R.id.moview_poster1);
        Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w500" + img)
                .placeholder(R.drawable.ic_cloud_download_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp)
                .noFade()
                .into(i);
        TextView over = findViewById(R.id.movie_overview);
        over.setText(overview);

    }
}
