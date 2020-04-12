package com.example.moviedatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FeedAdap extends RecyclerView.Adapter<FeedAdap.FeedDataHolder> {
    ArrayList<FeedData> feedData = new ArrayList<>();
    Context context;
    FeedAdap(Context context, ArrayList<FeedData>feedData){
        this.feedData = feedData;
        this.context = context;
    }
    @NonNull
    @Override
    public FeedAdap.FeedDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_view, parent, false);
        return new FeedDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdap.FeedDataHolder holder, final int position) {
       holder.title.setText(feedData.get(position).getTilte());
        Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w500" + feedData.get(position).getImg())
                .placeholder(R.drawable.ic_cloud_download_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp)
                .noFade()
                .into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,aboutMovie.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putExtra("overview",feedData.get(position).getOverview());
                i.putExtra("title",feedData.get(position).getTilte());
                i.putExtra("img",feedData.get(position).getImg());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return feedData.size();
    }

    class FeedDataHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView title;

        public FeedDataHolder(View v){
            super( v);
            img =  v.findViewById(R.id.moview_poster);
            title = v.findViewById(R.id.movie_title);

        }
    }



}
