package moviedbapi.swathi.example.moviedbapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import moviedbapi.swathi.example.moviedbapi.adapterclass.MovieAdapter;
import moviedbapi.swathi.example.moviedbapi.apiclientclass.ApiClient;
import moviedbapi.swathi.example.moviedbapi.interfaceclass.ApiInterface;
import moviedbapi.swathi.example.moviedbapi.pojo.MovieData;
import moviedbapi.swathi.example.moviedbapi.pojo.MovieResponseList;
import moviedbapi.swathi.example.moviedbapi.pojo.Results;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by swath on 8/29/2018.
 */

public class HomeActivity extends AppCompatActivity {
    EditText editText_search;
    Button button_search;
    TextView textView_errorMessage;
    private static final String TAG = "HomeActivity";
    private RecyclerView recyclerView;
    private static Retrofit retrofit = null;
    private Call<MovieData> movies;
    private MovieAdapter adapter;
    private LinearLayoutManager manager;
    private List<Results> results;
    private boolean isRequesting = false;//As the user scrolls we shall be checking first if there is a request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        results = new ArrayList<Results>(); //The word results is not necessary inside arrylist!!! OPTIOONAL
        adapter = new MovieAdapter(results);
        //I am taking too long because it is slow and i can not see cleaery
        editText_search = (EditText) findViewById(R.id.searchEditText);
        button_search = (Button) findViewById(R.id.buttonSearch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView_errorMessage = (TextView) findViewById(R.id.textViewMessage);
//        setSupportActionBar(toolbar);
        manager= new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.recyclerViewMovies);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_data = editText_search.getText().toString();
                Log.i(TAG, "search data : " + search_data);
                if (search_data.isEmpty() || search_data == null)
                    textView_errorMessage.setVisibility(View.VISIBLE);
                else {
                    Log.i(TAG, "connect");
                    connectAndGetApiData(search_data);
                }
            }
        });
    }

    public void connectAndGetApiData(String search_data) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieData> call = apiInterface.getBooksResponse(search_data, ApiClient.API_KEY);


        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                Log.d(TAG, String.valueOf(response.body()));
                if (response.body() != null) {
                    Log.d("response", "response");
                    results.addAll(response.body().items);
                    adapter.notifyDataSetChanged();
                    //Run it now S, the recyclerview does not have ny layout manager. hahahahah lets addd

                } else {
                    Log.d("response", " no response");
                }

//
//
// List<Results> results = response.body().getItems();
//                if (results == null || results.isEmpty()) {
//                    textView_errorMessage.setVisibility(View.VISIBLE);
//                    return;
//                }
//                textView_errorMessage.setVisibility(View.GONE);
//                recyclerView.setAdapter(new MovieAdapter(results));
//                movies.addAll(response.body().getItems());
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {

            }

        });
       /* Call<MovieData> call = apiInterface.getBooksResponse(search_data, ApiClient.API_KEY);

        call.enqueue(new Callback<MovieResponseList>() {


            @Override
            public void onResponse(Call<MovieResponseList> call, Response<MovieResponseList> response) {
                List<MovieData> movieData = response.body().getItems();
                if(movieData == null || movieData.isEmpty()){
                    textView_errorMessage.setVisibility(View.VISIBLE);
                    return;
                }
                textView_errorMessage.setVisibility(View.GONE);
                recyclerView.setAdapter(new MovieAdapter(movieData));
            }

            @Override
            public void onFailure(Call<MovieResponseList> call, Throwable t) {

            }

        });
    }*/
    }
}
