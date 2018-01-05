package com.example.prachi.shopifytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,2);
        adapter=new ProductListAdapter(this,mproductlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
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
                    mproductlist.addAll(body.getResult());
                      Log.i("response",response.toString());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                Log.i("failure","failureoccured");

            }

            //@Override
            public boolean onCreateOptionsMenu(Menu menu) {
                //  Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.search_menu_item, menu);
                MenuItem searchItem = menu.findItem(R.id.search_icon);

                SearchView searchView = (SearchView) searchItem.getActionView();
                return true;
            }

            //  @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.search_icon) {
                    Intent i = new Intent();
                    i.setClass(ProductListActivity.this, SearchActivity.class);
                    startActivity(i);
                }
                return true;
            }
        })
    ;};
}