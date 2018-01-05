package com.example.prachi.shopifytestapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prachi.shopifytestapp.Network.ProductItemInfo;
import com.example.prachi.shopifytestapp.ProductListActivity;
import com.example.prachi.shopifytestapp.R;
import com.example.prachi.shopifytestapp.descriptionActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by prachi on 5/1/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    Context mcontext;
    ArrayList<ProductItemInfo> mproductList;
    String str;
    public ProductListAdapter(Context context, ArrayList<ProductItemInfo> productList){
         this.mcontext=context;
        this.mproductList=productList;
        Log.i("listsize",String.valueOf(mproductList.size()));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.product_list_item,parent,false);

        ProductListAdapter.ViewHolder vh=new ProductListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Picasso.with(mcontext).load(mproductList.get(position).getImages().get(0).getSrc()).into(holder.productImage);
        holder.productTitle.setText("TITLE: " +mproductList.get(position).getTitle());
        Log.i("producttitle",mproductList.get(position).getTitle());
       // holder.productType.setText(mproductList.get(position).getProduct_type());
       // Log.i("producttype",mproductList.get(position).getProduct_type());
        holder.productdesc.setText("DESCRIPTION : "+mproductList.get(position).getBody_html());
       // Log.i("productvendor",mproductList.get(position).getVendor());
//        str=mproductList.get(position).getOptions().get(0).getValues().get(0);
//        for(int i=1;i<mproductList.get(position).getOptions().size();i++){
//            str=str+","+mproductList.get(position).getOptions().get(0).getValues().get(i);
//        }
//        holder.availaibleIn.setText("COLORS: "+str);
        View.OnClickListener listner=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setClass(mcontext,descriptionActivity.class);
                i.putExtra("variant_list",mproductList.get(position).getVariants());
                i.putExtra("product_title",mproductList.get(position).getTitle());
                i.putExtra("product_vendor",mproductList.get(position).getVendor());
                i.putExtra("product_type",mproductList.get(position).getProduct_type());
                i.putExtra("product_image",mproductList.get(position).getImages().get(0).getSrc());
                mcontext.startActivity(i);
            }
        };
        holder.productImage.setOnClickListener(listner);
        holder.productTitle.setOnClickListener(listner);
        holder.productdesc.setOnClickListener(listner);
    }

    @Override
    public int getItemCount() {
        return mproductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productTitle;
       // TextView productType;
        TextView productdesc;
        TextView availaibleIn;
        public ViewHolder(View itemView) {
            super(itemView);
            productImage=(ImageView) itemView.findViewById(R.id.product_image);
            productTitle=(TextView) itemView.findViewById(R.id.product_title);
         //   productType=(TextView) itemView.findViewById(R.id.product_type);
            productdesc=(TextView) itemView.findViewById(R.id.product_desc);
            //availaibleIn=(TextView) itemView.findViewById(R.id.product_availaible_in);
        }
    }
}
