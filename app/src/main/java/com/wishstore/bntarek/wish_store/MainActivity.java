package com.wishstore.bntarek.wish_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by BnTarek on 21/8/2016.
 */

public class MainActivity extends AppCompatActivity {
    LinearLayout productCard;

    ImageView productThumbnailIV;
    TextView productNameTV;
    TextView productDescriptionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productCard = (LinearLayout) findViewById(R.id.product_card);

        productThumbnailIV = (ImageView) findViewById(R.id.product_thumbnail);
        productNameTV = (TextView) findViewById(R.id.product_name);
        productDescriptionTV = (TextView) findViewById(R.id.product_description);

        productThumbnailIV.setImageResource(R.drawable.cupcake);
        productNameTV.setText(R.string.cupcake_name);
        productDescriptionTV.setText(R.string.cupcake_description);

        productCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Nice choice!", Toast.LENGTH_SHORT).show();

                Intent inten = new Intent(MainActivity.this, OrderProduct.class);
                startActivity(inten);
            }
        });
    }
}
