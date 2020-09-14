package com.example.nutritionassistant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String basse_url="https://api.edamam.com/";
    @GET("search")
    Call<List<recipemodel>> getRecipie(@Query("q")String q,
                                       @Query("app_id")String appid,
                                       @Query("app_key")String appkey,
                                       @Query("from")int from,
                                       @Query("to")int to
                                       );

}
