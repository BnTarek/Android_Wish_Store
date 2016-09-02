package com.wishstore.bntarek.wish_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BnTarek on 21/8/2016.
 */

public class MainActivity extends AppCompatActivity {
    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";
    public static final String PRODUCT_THUMBNAIL = "PRODUCT_THUMBNAIL";

    private List<Product> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductsAdapter mAdapter;

    public interface ProductItemListener {
        void onProductClick(Product clickedProduct);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.products_list);

        mAdapter = new ProductsAdapter(productList, mItemListener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareProductList();
    }

    private void prepareProductList() {
        Product product = new Product("Cars", "Product 1 description", R.drawable.cars);
        productList.add(product);

        product = new Product("Monsters Inc.", "Product 2 description", R.drawable.monsters_inc);
        productList.add(product);

        product = new Product("Nemo", "Product 3 description", R.drawable.nemo);
        productList.add(product);

        product = new Product("Wall-E", "Product 4 description", R.drawable.wall_e);
        productList.add(product);

        mAdapter.notifyDataSetChanged();
    }

    ProductItemListener mItemListener = new ProductItemListener() {
        @Override
        public void onProductClick(Product clickedProduct) {
            Intent intent = new Intent(MainActivity.this, OrderProduct.class);
            intent.putExtra(PRODUCT_NAME, clickedProduct.getName());
            intent.putExtra(PRODUCT_DESCRIPTION, clickedProduct.getDescription());
            intent.putExtra(PRODUCT_THUMBNAIL, clickedProduct.getThumbnailUrl());
            startActivity(intent);
        }
    };
}
