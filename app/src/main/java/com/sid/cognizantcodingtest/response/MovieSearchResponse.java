package com.sid.cognizantcodingtest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sid.cognizantcodingtest.model.Movie;

import java.util.List;

public class MovieSearchResponse {
    @SerializedName("totalResults")
    @Expose()
    private int totalResults = 98;


    @SerializedName("Search")
    @Expose()
    private List<Movie> movieList;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "totalResults=" + totalResults +
                ", movieList=" + movieList +
                '}';
    }
}
