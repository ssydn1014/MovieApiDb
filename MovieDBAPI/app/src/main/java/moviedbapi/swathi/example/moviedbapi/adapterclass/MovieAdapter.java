package moviedbapi.swathi.example.moviedbapi.adapterclass;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import moviedbapi.swathi.example.moviedbapi.R;
import moviedbapi.swathi.example.moviedbapi.pojo.Results;

/**
 * Created by swath on 8/29/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>  {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.movie_layout, parent, false);
        return new ViewHolder(listItem);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {

        Results movieData = data.get(position);
        holder.textView_rating.setText(movieData.vote_average);
        holder.textView_title.setText(movieData.title);
        holder.textView_Language.setText(movieData.original_language);
        Picasso.with(holder.imageView_movie.getContext()).load(movieData.poster_path).into(holder.imageView_movie);


 }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
    private List<Results> data;

    public MovieAdapter(List<Results> data) {
        this.data = data;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView_movie;
        public TextView textView_title;
        public TextView textView_Language;
        public TextView textView_rating;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView_movie = (ImageView) itemView.findViewById(R.id.imageViewMovie);
            this.textView_title = (TextView) itemView.findViewById(R.id.textMovieName);
            this.textView_Language = (TextView) itemView.findViewById(R.id.textViewMovieLanguage);
            this.textView_rating = (TextView)itemView.findViewById(R.id.textView_rating);
        }
    }
}


