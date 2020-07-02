package com.sid.cognizantcodingtest.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.sid.cognizantcodingtest.model.Movie;
import com.sid.cognizantcodingtest.requests.MovieApiClient;

import java.util.List;

public class MovieRepository {
    private static final String TAG = "MovieRepository";
    private static MovieRepository mInstance = null;
    private MovieApiClient mMovieApiClient;
    private String mQuery;
    private MediatorLiveData<List<Movie>> mMovies = new MediatorLiveData<>();

    public static MovieRepository getInstance(){
        if(mInstance == null){
            mInstance = new MovieRepository();
        }
        return mInstance;
    }

    private MovieRepository(){
        mMovieApiClient = MovieApiClient.getInstance();
        initMedistors();
    }

    private void initMedistors(){
        LiveData<List<Movie>> movieListApiSource = mMovieApiClient.getMovies();
        mMovies.addSource(movieListApiSource, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if(movies != null){
                    mMovies.setValue(movies);
                }
            }
        });
    }

    public void searchMovieApi(String query){
        mQuery = query;
        Log.d(TAG,"Query: "+query);
        mMovieApiClient.searchMoviesApi(query);
    }

    public void searchRoomsApi(){
        mMovieApiClient.searchRoomsApi();
    }


    public void searchMovieById(String movieID){
        mMovieApiClient.searchMovieById(movieID);
    }

    public LiveData<List<Movie>> getMovies(){
        return mMovies;
    }

    public LiveData<Movie> getMovie(){
        return mMovieApiClient.getMovie();
    }

}
