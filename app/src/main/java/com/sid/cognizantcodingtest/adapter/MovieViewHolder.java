package com.sid.cognizantcodingtest.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sid.cognizantcodingtest.R;

class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView title;
    ImageView img;
    OnMovieListener onMovieListener;
    public MovieViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);
        this.onMovieListener = onMovieListener;
        title = (TextView) itemView.findViewById(R.id.movie_title);
        img = (ImageView) itemView.findViewById(R.id.movie_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onMovieListener.onMovieClick(getAdapterPosition());
    }
}
