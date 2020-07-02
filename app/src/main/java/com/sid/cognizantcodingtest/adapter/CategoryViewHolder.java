package com.sid.cognizantcodingtest.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sid.cognizantcodingtest.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CircleImageView circleImageView;
    TextView categoryTitle;
    OnMovieListener listener;

    public CategoryViewHolder(@NonNull View itemView, OnMovieListener listener) {
        super(itemView);
        this.listener = listener;
        circleImageView = itemView.findViewById(R.id.category_image);
        categoryTitle = itemView.findViewById(R.id.category_title);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onCategoryClick(categoryTitle.getText().toString());
    }
}
