package moviedbapi.swathi.example.moviedbapi.holderclass;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import moviedbapi.swathi.example.moviedbapi.R;


/**
 * Created by swath on 8/29/2018.
 */


public class ViewHolder extends  RecyclerView.ViewHolder {

    public ImageView imageView_movie;
    public TextView textView_title;
    public TextView textView_Language;
    public TextView textView_rating;


    public ViewHolder(View itemView) {
        super(itemView);
        this.imageView_movie = (ImageView) itemView.findViewById(R.id.imageViewMovie);
        this.textView_title = (TextView) itemView.findViewById(R.id.textMovieName);
        this.textView_Language = (TextView) itemView.findViewById(R.id.textViewMovieLanguage);
        this.textView_rating = (TextView) itemView.findViewById(R.id.textView_rating);

}
}
