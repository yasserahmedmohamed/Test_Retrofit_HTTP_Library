package com.example.yasserahmed.test_retrofit_http_library;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.yasserahmed.test_retrofit_http_library.Models.ApiClient;
import com.example.yasserahmed.test_retrofit_http_library.Models.ApiInterface;
import com.example.yasserahmed.test_retrofit_http_library.Models.Movie;
import com.example.yasserahmed.test_retrofit_http_library.Models.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "cbc4dcf1540ca46e94a63ac9fea166d7";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        if (API_KEY.isEmpty()){
            Toast.makeText(context,"please add your api key",Toast.LENGTH_SHORT).show();
            return;
        }
        ApiInterface apiInterface=new ApiClient().getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d("test", "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("test", t.toString());
            }
        });


    }
}
