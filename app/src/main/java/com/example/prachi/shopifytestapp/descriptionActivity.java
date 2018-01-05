package com.example.prachi.shopifytestapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.prachi.shopifytestapp.Network.ApiClient;
import com.example.prachi.shopifytestapp.Network.ApiInterface;
import com.example.prachi.shopifytestapp.Network.ProductItemInfo;
import com.example.prachi.shopifytestapp.Network.ProductListResponse;
import com.example.prachi.shopifytestapp.Network.variantResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class descriptionActivity extends AppCompatActivity {
    ArrayList<variantResponse> variantproducts;
    String title;
    String vendors;
    String prodtype;
    String imagesrc;
    LinearLayout root;
    FrameLayout fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        root=(LinearLayout) findViewById(R.id.descriptionlinearlayout);

        variantproducts=new ArrayList<>();
        Intent i = getIntent();
        variantproducts=(ArrayList<variantResponse>) i.getSerializableExtra("variant_list");
        Log.i("variantsize",String.valueOf(variantproducts.size()));
        title=i.getStringExtra("product_title");
        vendors=i.getStringExtra("product_vendor");
        prodtype=i.getStringExtra("product_type");
        imagesrc=i.getStringExtra("product_image");
        TextView productTitle=(TextView) findViewById(R.id.producttitle);
        TextView producttype=(TextView) findViewById(R.id.producttype);
        TextView productvendor=(TextView) findViewById(R.id.productvendor);
        ImageView productimage=(ImageView) findViewById(R.id.productimage);
        productTitle.setText("PRODUCT NAME: " +title);

        producttype.setText("PRODUCT TYPE: " +prodtype);
        productvendor.setText("PRODUCT VENDORS: "+vendors);
        Picasso.with(this).load(imagesrc).into(productimage);
        int variantsize=variantproducts.size();
        TextView price;
        TextView weight;
        ImageView prodimage;
        TextView color;
        for(int j=0;j<variantsize;j++){
            View v= getLayoutInflater().inflate(R.layout.variant_item_view, null);
            price=(TextView) v.findViewById(R.id.variantprice);
            weight=(TextView) v.findViewById(R.id.variantweight);
            prodimage=(ImageView) v.findViewById(R.id.varientimage);
            color=(TextView) v.findViewById(R.id.variantcolor);
            price.setText("PRICE: "+variantproducts.get(j).getPrice());

            weight.setText("WEIGHT: "+variantproducts.get(j).getWeight());

            color.setText("COLOR: "+variantproducts.get(j).getTitle());

            Picasso.with(this).load(imagesrc).into(prodimage);
            root.addView(v);
    }






    }
}
