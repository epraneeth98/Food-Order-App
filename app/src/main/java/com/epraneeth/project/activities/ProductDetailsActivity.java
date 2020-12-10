package com.epraneeth.project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.epraneeth.project.R;
import com.epraneeth.project.classes.Product;
import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textViewName, textViewDescription, textViewMrp, textViewPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        savedInstanceState = getIntent().getExtras();
        Product p = savedInstanceState.getParcelable("data");
        imageView = findViewById(R.id.image_view);
        Picasso.with(this).load("https://rjtmobile.com/grocery/images/"+p.getImage()).into(imageView);

        textViewName = findViewById(R.id.text_name);
        textViewName.setText(p.getProductName());

        textViewDescription = findViewById(R.id.text_description);
        textViewDescription.setText(p.getDescription());

        textViewMrp = findViewById(R.id.mrp);
        textViewMrp.setText("₹ "+String.valueOf(p.getMrp()));
        textViewMrp.setPaintFlags(textViewMrp.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        textViewPrice = findViewById(R.id.price);
        textViewPrice.setText("₹ "+String.valueOf(p.getPrice()));

    }
}