package com.example.yasserahmed.test_retrofit_http_library.Models;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yasser ahmed on 12/21/2017.
 */

public class ApiClient {

    public static final String BASE_URL="http://api.themoviedb.org/3";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
