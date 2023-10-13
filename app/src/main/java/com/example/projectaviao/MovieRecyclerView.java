/*package com.example.projectaviao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieRecyclerView  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

private List<MovieModel> mMovies;
private OnMovieListenner mOnMovieListenner;

public static final int DIPLAY_POP=1;
public static final int DISPLAY_SEARCH=2;

public MovieRecyclerView(OnMovieListenner onMovieListenner){
    mOnMovieListenner = onMovieListenner;
}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View mView;
if(viewType == DISPLAY_SEARCH){
    mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.info_viagem_fragment,parent,false);
    return new MovieViewHolder(mView ,mOnMovieListenner);
} else{
    mView= LayoutInflater.from();
}

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}*/
