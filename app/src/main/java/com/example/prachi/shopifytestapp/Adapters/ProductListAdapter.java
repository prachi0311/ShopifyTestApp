package com.example.prachi.shopifytestapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prachi.shopifytestapp.Network.ProductItemInfo;
import com.example.prachi.shopifytestapp.ProductListActivity;
import com.example.prachi.shopifytestapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by prachi on 5/1/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    Context mcontext;
    ArrayList<ProductItemInfo> mproductList;
    public ProductListAdapter(Context context, ArrayList<ProductItemInfo> productList){
         this.mcontext=context;
        this.mproductList=productList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.product_list_item,parent,false);

        ProductListAdapter.ViewHolder vh=new ProductListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(mcontext).load(mproductList.get(position).getImages().get(0).getSrc()).into(holder.productImage);
        holder.productTitle.setText(mproductList.get(position).getTitle());
        holder.productType.setText(mproductList.get(position).getProduct_type());
        holder.productVendor.setText(mproductList.get(position).getVendor());
        holder.availaibleIn.setText(mproductList.get(position).getOptions().get(0).getValues().get(0));
    }

    @Override
    public int getItemCount() {
        return mproductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productTitle;
        TextView productType;
        TextView productVendor;
        TextView availaibleIn;
        public ViewHolder(View itemView) {
            super(itemView);
            productImage=(ImageView) itemView.findViewById(R.id.product_image);
            productTitle=(TextView) itemView.findViewById(R.id.product_title);
            productType=(TextView) itemView.findViewById(R.id.product_type);
            productVendor=(TextView) itemView.findViewById(R.id.product_vendor);
            availaibleIn=(TextView) itemView.findViewById(R.id.product_availaible_in);
        }
    }
}
