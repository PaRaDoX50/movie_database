package com.example.moviedatabase;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class ApiResponse {
    public static String mUrl="https://api.themoviedb.org/3/discover/movie?api_key=c604ddb180c79f41f9d9a4faf4b59c03&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
    public static RequestQueue requestQueue;
    public static JSONObject result;



    static void OnResponse(JSONObject response){
      result = response;


    }

    public static JSONObject method(final Context context) {

     requestQueue = Volley.newRequestQueue(context);

//     JSONObject jsonObject = new JSONObject();
//     try {
//      jsonObject.put("api_key","c604ddb180c79f41f9d9a4faf4b59c03");
//     } catch (JSONException e) {
//      e.printStackTrace();
//     }

//     JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {
//      @Override
//      public void onResponse(JSONObject response) {
//        OnResponse(response);
//      }
//     }, new Response.ErrorListener() {
//      @Override
//      public void onErrorResponse(VolleyError error) {
//
//      }
//     });
//        StringRequest request = new StringRequest(Request.Method.GET, mUrl,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        OnResponse(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
         final JSONObject jsonObject;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        OnResponse(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
     requestQueue.add(jsonObjectRequest);
        Log.d("from Onresponse", "OnRespons]]]]]]]e: "+result.toString());
     return result;

    }

}
