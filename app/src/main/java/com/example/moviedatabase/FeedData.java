package com.example.moviedatabase;

public class FeedData {
    String mTilte;
    String mImg;
    String mOverview;
    FeedData(String Title, String Img, String Overview){
        mImg = Img;
        mTilte = Title;
        mOverview = Overview;
    }

    public String getImg() {
        return mImg;
    }

    public String getTilte() {
        return mTilte;
    }

    public String getOverview() {
        return mOverview;
    }
}
