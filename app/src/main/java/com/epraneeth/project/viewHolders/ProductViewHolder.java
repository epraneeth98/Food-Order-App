package com.epraneeth.project.viewHolders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epraneeth.project.R;
import com.epraneeth.project.activities.ProductDetailsActivity;
import com.epraneeth.project.classes.Product;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textViewName;
    public TextView mrp;
    public TextView price;
    public Product product;
    public ProductViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view);
        textViewName = itemView.findViewById(R.id.text_name);
        mrp = itemView.findViewById(R.id.mrp);
        price = itemView.findViewById(R.id.price);
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", product);
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
    }
}
