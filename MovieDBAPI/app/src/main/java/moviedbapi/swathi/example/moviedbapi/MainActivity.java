package moviedbapi.swathi.example.moviedbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import moviedbapi.swathi.example.moviedbapi.adapterclass.MovieAdapter;
import moviedbapi.swathi.example.moviedbapi.apiclientclass.ApiClient;
import moviedbapi.swathi.example.moviedbapi.interfaceclass.ApiInterface;
import moviedbapi.swathi.example.moviedbapi.pojo.MovieData;
import moviedbapi.swathi.example.moviedbapi.pojo.Results;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by swath on 8/29/2018.
 */
public class MainActivity extends AppCompatActivity {
      EditText editText_serachbar;
    private static final String TAG = "MainActivity";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextView errorMessage;
    private static Retrofit retrofit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        editText_serachbar = (EditText) findViewById(R.id.editTextSearch);
//        errorMessage = (TextView) findViewById(R.id.errorMessage);
//
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//
//        editText_serachbar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    String search_data = String.valueOf(editText_serachbar.getText());
//                    Log.i(TAG, "search data" + search_data);
//                    connectAndGetApiData(search_data);
//                    return true;
//                }
//                return false;
//            }
//        });
    }
    public void connectAndGetApiData(String search_data) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieData> call = apiInterface.getBooksResponse(search_data, ApiClient.API_KEY);

        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                List<Results> movies = response.body().getItems();
                if(movies == null || movies.isEmpty()){
                    errorMessage.setVisibility(View.VISIBLE);
                    return;
                }
                errorMessage.setVisibility(View.GONE);
//                recyclerView.setAdapter(new MovieAdapter(movies));
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {

            }

        });
    }
}
