package com.code.saher.airlines_instabug.Interfaces;

import com.code.saher.airlines_instabug.Model.Airline;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saher on 8/11/2016.
 */
public interface Retrofitinterface {

    @GET("h/mobileapis/directory/airlines")
    Call<ArrayList<Airline>> getData();

//    @GET("3/movie/popular?api_key="+MOVIES_API_KEY)
//    Call<Movie> getPopularData();
//
//    @GET("3/movie/top_rated?api_key="+MOVIES_API_KEY)
//    Call<Movie> getTopRatedData();
//
//    @GET("3/movie/{id}/videos?api_key="+MOVIES_API_KEY)
//    Call<Video> getVideos(@Path("id") String id);
//
//    @GET("3/movie/{id}/reviews?api_key="+MOVIES_API_KEY)
//    Call<Movie> getReviews(@Path("id") String id);

}
