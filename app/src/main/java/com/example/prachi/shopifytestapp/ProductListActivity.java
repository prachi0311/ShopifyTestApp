package com.example.prachi.shopifytestapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.prachi.shopifytestapp.Adapters.ProductListAdapter;
import com.example.prachi.shopifytestapp.Network.ApiClient;
import com.example.prachi.shopifytestapp.Network.ApiInterface;
import com.example.prachi.shopifytestapp.Network.ProductItemInfo;
import com.example.prachi.shopifytestapp.Network.ProductListResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {
    ProductListAdapter adapter;
    ArrayList<ProductItemInfo> mproductlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        mproductlist=new ArrayList<>();
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.product_list_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,1);
        adapter=new ProductListAdapter(this,mproductlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setClass(ProductListActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        fetchProductList();

    }
    private void fetchProductList() {
        ApiInterface apiinterface= ApiClient.getApiinterface();
        Call<ProductListResponse> popularmovies=apiinterface.getProductList();
        popularmovies.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                if (response.isSuccessful()) {
                    mproductlist.clear();
                    ProductListResponse body = response.body();
                    mproductlist.addAll(body.getProducts());
                      Log.i("response",String.valueOf(mproductlist.size()));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                Log.i("failure",t.toString());

            }


        })
    ;};
}