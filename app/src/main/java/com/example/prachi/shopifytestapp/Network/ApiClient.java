package com.example.prachi.shopifytestapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prachi on 5/1/18.
 */

public class ApiClient {
    static ApiInterface apiinterface;

    public static ApiInterface getApiinterface(){
        if(apiinterface==null){

            Retrofit retrofit= new Retrofit.Builder().baseUrl("https://shopicruit.myshopify.com/admin/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            apiinterface=retrofit.create(ApiInterface.class);
        }
        return apiinterface;
    }
}
