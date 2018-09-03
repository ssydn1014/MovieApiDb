package moviedbapi.swathi.example.moviedbapi.pojo;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Created by swath on 8/29/2018.
 */

public class MovieData {
    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public  Results results;
    public String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotla_pages() {
        return totla_pages;
    }

    public void setTotla_pages(String totla_pages) {
        this.totla_pages = totla_pages;
    }

    public String totla_pages;

   public List<Results> getItems() {
        Log.d("items", String.valueOf(items));
        return items;
    }

    public void setItems(List<Results> items) {
        this.items = items;
    }
    @SerializedName("items")
    public List<Results> items;



}
