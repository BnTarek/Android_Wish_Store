package com.wishstore.bntarek.wish_store;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by BnTarek on 21/8/2016.
 */

public class OrderProduct extends AppCompatActivity {
    private String productName;
    private String productDescription;
    private int productThumbnail;
    private int productQuantity = 1;
    private boolean isFastShipping = false;

    private ImageView mThumbnail;
    private TextView mDescription;

    private Button mIncreaseBtn;
    private Button mDecreaseBtn;
    private TextView mQuantityET;

    private CheckBox mFastShippingCB;
    private Button mOrderBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_order);

        productName = getIntent().getStringExtra(MainActivity.PRODUCT_NAME);
        productDescription = getIntent().getStringExtra(MainActivity.PRODUCT_DESCRIPTION);
        productThumbnail = getIntent().getIntExtra(MainActivity.PRODUCT_THUMBNAIL, 0);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(productName);

        mThumbnail = (ImageView) findViewById(R.id.product_thumbnail);
        mDescription = (TextView) findViewById(R.id.product_description);

        mIncreaseBtn = (Button) findViewById(R.id.increase_btn);
        mDecreaseBtn = (Button) findViewById(R.id.decrease_btn);
        mQuantityET = (TextView) findViewById(R.id.quantity_et);

        mFastShippingCB = (CheckBox) findViewById(R.id.fast_shipping_cb);
        mOrderBtn = (Button) findViewById(R.id.order_btn);

        mThumbnail.setImageResource(productThumbnail);
        mDescription.setText(productDescription);

        mIncreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(mQuantityET.getText().toString());

                if(quantity < 99) {
                    quantity++;
                    mQuantityET.setText(quantity + "");
                    productQuantity = quantity;
                } else {
                    Toast.makeText(OrderProduct.this, R.string.quantity_max_error, Toast.LENGTH_LONG).show();
                }
            }
        });

        mDecreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(mQuantityET.getText().toString());

                if(quantity > 1) {
                    quantity--;
                    mQuantityET.setText(quantity + "");
                    productQuantity = quantity;
                } else {
                    Toast.makeText(OrderProduct.this, R.string.quantity_min_error, Toast.LENGTH_LONG).show();
                }
            }
        });

        mFastShippingCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFastShippingCB.isChecked()) {
                    isFastShipping = true;
                } else {
                    isFastShipping = false;
                }
            }
        });

        mOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderSummary;

                orderSummary = "Product name: " + productName +
                        "\nProduct description: " + productDescription +
                        "\nQuantity: " + productQuantity +
                        "\nFast Shipping: " + isFastShipping;

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","mohammad.bn.tarek@gmail.com", null));

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order for " + productName);
                emailIntent.putExtra(Intent.EXTRA_TEXT, orderSummary);

                startActivity(Intent.createChooser(emailIntent, "Send Email"));
            }
        });
    }
}