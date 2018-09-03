package moviedbapi.swathi.example.moviedbapi.apiclientclass;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by swath on 8/29/2018.
 */


public class ApiClient {
    public static final String BASE_URL ="http://api.themoviedb.org/3/movie/";
    public final static String API_KEY = "b570a10e1fec629363134056a1b5b394";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){

       if (retrofit == null) {
             retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
       }

        return retrofit;
    }

}
