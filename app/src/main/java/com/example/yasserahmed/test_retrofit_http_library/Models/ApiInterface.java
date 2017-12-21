package com.example.yasserahmed.test_retrofit_http_library.Models;
import com.example.yasserahmed.test_retrofit_http_library.Models.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yasser ahmed on 12/21/2017.
 */

public class ApiInterface {
    @GET("movie/top_rated")
    public Call<com.example.yasserahmed.test_retrofit_http_library.Models.MovieResponse> getTopRatedMovies(@Query("api_key") String api_key) {
        return null;
    }

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey) {
        return null;
    }

}
