package com.wishstore.bntarek.wish_store;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by BnTarek on 21/8/2016.
 */

public class OrderProduct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_order);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Order Product");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
