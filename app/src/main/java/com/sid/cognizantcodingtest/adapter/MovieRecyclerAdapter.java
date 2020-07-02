package com.sid.cognizantcodingtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sid.cognizantcodingtest.R;
import com.sid.cognizantcodingtest.model.Movie;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MOVIE_TYPE = 1;
    private static final int LOADING_TYPE = 2;
    private static final int CATEGORY_TYPE = 3;


    private List<Movie> mMovie;
    private OnMovieListener onMovieListener;

    public MovieRecyclerAdapter(OnMovieListener onMovieListener){
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = null;
        switch (viewType){
            case MOVIE_TYPE:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_movie_list_item,viewGroup,false);
                return new MovieViewHolder(view,onMovieListener);
            }
            case CATEGORY_TYPE:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_category_list_item,viewGroup,false);
                return new CategoryViewHolder(view,onMovieListener);
            }
            default:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_movie_list_item,viewGroup,false);
                return new MovieViewHolder(view,onMovieListener);
            }

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType == MOVIE_TYPE){
            RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
            Glide.with(viewHolder.itemView.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(mMovie.get(position).getPoster())
                    .into(((MovieViewHolder) viewHolder).img);
            ((MovieViewHolder) viewHolder).title.setText(mMovie.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if(mMovie != null){
            return mMovie.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(mMovie.get(position).getTitle().equals("LOADING...")){
            return LOADING_TYPE;
        }else if (position == mMovie.size()-1 && position !=0){
            return LOADING_TYPE;
        }else {
            return MOVIE_TYPE;
        }
    }

/*    public void displaySearchCategory(){
        List<Movie> categories = new ArrayList<>();
        for (int i = 0; i< Constants.DEFAULT_SEARCH_CATEGORIES.length; i++){
            Movie recipe = new Movie();
            recipe.setTitle(Constants.DEFAULT_SEARCH_CATEGORIES[i]);
            recipe.setPoster(Constants.DEFAULT_SEARCH_CATEGORY_IMAGES[i]);
            categories.add(recipe);
        }
        mMovie = categories;
        notifyDataSetChanged();
    }*/

    public void setMovie(List<Movie> movie){
        this.mMovie = movie;
        notifyDataSetChanged();
    }

    public Movie getSelectedMovie(int position){
        if(mMovie != null){
            if (mMovie.size() > 0){
                return mMovie.get(position);
            }
        }
        return null;
    }
}
