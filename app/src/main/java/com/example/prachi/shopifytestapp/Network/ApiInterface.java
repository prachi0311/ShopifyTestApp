package com.example.prachi.shopifytestapp.Network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by prachi on 5/1/18.
 */

public interface ApiInterface {

    @GET("products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ProductListResponse>  getProductList();

}
