package com.example.prachi.shopifytestapp.Network;

import java.io.Serializable;

/**
 * Created by prachi on 5/1/18.
 */

public class variantResponse implements Serializable {
    long id;
    String price;
    String weight;
    String weight_unit;
    String title;

    public long getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public String getTitle() {
        return title;
    }
}
