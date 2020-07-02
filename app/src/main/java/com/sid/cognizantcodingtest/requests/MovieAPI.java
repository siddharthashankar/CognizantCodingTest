package com.sid.cognizantcodingtest.requests;

import com.sid.cognizantcodingtest.response.MovieResponse;
import com.sid.cognizantcodingtest.response.MovieSearchResponse;
import com.sid.cognizantcodingtest.response.RoomResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MovieAPI {

    //Search request
   // @GET("yuhong90/7ff8d4ebad6f759fcc10cc6abdda85cf/raw/463627e7d2c7ac31070ef409d29ed3439f7406f6/room-availability.json")

    @GET
    Call<RoomResponse> searchRoom(@Url String url);

    //Search request
   @GET("/")
   Call<MovieSearchResponse> searchMovie(
           @Query("apikey") String apikey,
           @Query("s") String query,
           @Query("type") String type

   );

    //Movie Request
   @GET("/")
    Call<MovieResponse> getMovieResponse(
            @Query("apikey") String key,
            @Query("i") String response_id

   );
}
