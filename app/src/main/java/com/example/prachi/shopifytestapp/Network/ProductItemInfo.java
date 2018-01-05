package com.example.prachi.shopifytestapp.Network;

import java.util.ArrayList;

/**
 * Created by prachi on 5/1/18.
 */

public class ProductItemInfo {
    long id;
    String title;
    String vendor;
    String product_type;
    String body_html;

    public String getBody_html() {
        return body_html;
    }

    ArrayList<variantResponse> variants=new ArrayList<>();
    ArrayList<optionResponse> options=new ArrayList<>();



    ArrayList<imageResponse> images=new ArrayList<>();
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setVariants(ArrayList<variantResponse> variants) {
        this.variants = variants;
    }

    public void setOptions(ArrayList<optionResponse> options) {
        this.options = options;
    }

    public void setImages(ArrayList<imageResponse> images) {
        this.images = images;
    }

    public String getVendor() {
        return vendor;

    }

    public String getProduct_type() {
        return product_type;
    }

    public ArrayList<variantResponse> getVariants() {
        return variants;
    }

    public ArrayList<optionResponse> getOptions() {
        return options;
    }
    public ArrayList<imageResponse> getImages() {
        return images;
    }
}
