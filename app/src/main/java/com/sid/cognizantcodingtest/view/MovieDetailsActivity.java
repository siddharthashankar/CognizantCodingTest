package com.sid.cognizantcodingtest.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sid.cognizantcodingtest.R;
import com.sid.cognizantcodingtest.model.Movie;
import com.sid.cognizantcodingtest.viewmodels.MovieDetailsViewModel;

public class MovieDetailsActivity extends BaseActivity {
    private static final String TAG = "MovieDetailsActivity";
    // UI components
    private ImageView mRecipeImage;
    private TextView mMovieTitle, mYear, mRuntime, mRating, mSynopsisText, mScoreText, mReviewText, mDirectorName, mWriterName, mActorName;
    private LinearLayout mRecipeIngredientsContainer;
    private ScrollView mScrollView;
    private MovieDetailsViewModel mMovieDetailsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        mRecipeImage = findViewById(R.id.movie_image);
        mMovieTitle = findViewById(R.id.movie_title);
        mYear = findViewById(R.id.year);
        mRuntime = findViewById(R.id.runtime);
        mRating = findViewById(R.id.rating);
        mSynopsisText = findViewById(R.id.synopsisText);
        mScoreText = findViewById(R.id.scoreText);
        mReviewText = findViewById(R.id.reviewText);
        mDirectorName = findViewById(R.id.directorName);
        mWriterName = findViewById(R.id.writerName);
        mActorName = findViewById(R.id.actorName);
       // mRecipeIngredientsContainer = findViewById(R.id.ingredients_container);
        mScrollView = findViewById(R.id.parent);

        mMovieDetailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel.class);
        subscribeObserver();
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("movie")) {
            Movie recipe = getIntent().getParcelableExtra("movie");
            mMovieDetailsViewModel.searchMovieById(recipe.getImdbID());
        }
    }

    private void subscribeObserver(){
        mMovieDetailsViewModel.getMovie().observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(Movie movie) {
                if(movie != null){
                    if(movie.getImdbID().equals(mMovieDetailsViewModel.getMovieId())){
                        setMovieProperties(movie);
                        mMovieDetailsViewModel.setmDidRetrieveMovie(true);
                    }
                }
            }
        });

/*        mMovieDetailsViewModel.isRecipeRequestTimedOut().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean && !mRecipeViewModel.didRetrieveRecipe()){
                    Log.d(TAG,"onChanged: Timeout...");
                    displayErrorScreen("Error retrieving data. Check network connection.");
                }
            }
        });*/
    }

    private void setMovieProperties(Movie movie){
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        Glide.with(this)
                .setDefaultRequestOptions(requestOptions)
                .load(movie.getPoster())
                .into(mRecipeImage);
        mMovieTitle.setText(movie.getTitle());
        mYear.setText(movie.getYear());
        mRuntime.setText(movie.getRuntime());
        mRating.setText(movie.getImdbRating());
        mSynopsisText.setText(movie.getPlot());
        mScoreText.setText(movie.getImdbRating());
        mReviewText.setText(movie.getImdbVotes());
        mDirectorName.setText(movie.getDirector());
        mWriterName.setText(movie.getWriter());
        mActorName.setText(movie.getActors());

        showParent();
        showProgressBar(false);
    }

    private void showParent(){
        mScrollView.setVisibility(View.VISIBLE);
    }
}
