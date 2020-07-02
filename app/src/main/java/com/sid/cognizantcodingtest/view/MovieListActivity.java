package com.sid.cognizantcodingtest.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sid.cognizantcodingtest.R;
import com.sid.cognizantcodingtest.adapter.MovieRecyclerAdapter;
import com.sid.cognizantcodingtest.adapter.OnMovieListener;
import com.sid.cognizantcodingtest.model.Movie;
import com.sid.cognizantcodingtest.viewmodels.MovieListViewModel;

import java.util.List;

public class MovieListActivity extends BaseActivity implements OnMovieListener {
    private static final String TAG = "MovieListActivity";
    private MovieRecyclerAdapter mAdapter;
    private MovieListViewModel mMovieListViewModel;
    private RecyclerView recyclerView;
    private SearchView mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        mSearchView = findViewById(R.id.searchView);
        //ViewModel
        mMovieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        initRecyclerView();
        subscribeObservers();
        initSearchView();
    }

    private void subscribeObservers(){
        mMovieListViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (movies != null){
                   mAdapter.setMovie(movies);
                }
            }
        });
    }

    private void initRecyclerView(){
        mAdapter = new MovieRecyclerAdapter(this);
        VerticalSpacingItemDecoration decoration = new VerticalSpacingItemDecoration(5);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollVertically(1)){
                    //searchNextPage
                }

            }
        });
    }

    private void initSearchView(){
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG,"Query: "+query);
               // mMovieListViewModel.searchMovieApi(query);
                mMovieListViewModel.searchRoomsApi();
                mSearchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }



    @Override
    public void onMovieClick(int position) {
        Toast.makeText(this,"clicked on position "+position,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MovieListActivity.this, MovieDetailsActivity.class);
        intent.putExtra("movie", mAdapter.getSelectedMovie(position));
        startActivity(intent);

    }

    @Override
    public void onCategoryClick(String category) {
       // mMovieListViewModel.searchMovieApi(category);
        mMovieListViewModel.searchRoomsApi();
        mSearchView.clearFocus();
    }

}
