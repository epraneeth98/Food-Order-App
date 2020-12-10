package com.epraneeth.project.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epraneeth.project.R;
import com.epraneeth.project.classes.Product;
import com.epraneeth.project.viewHolders.ProductViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    Context mContext;
    ArrayList<Product> productArrayList;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        mContext = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.product_row_design, parent, false);
        return new ProductViewHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.product = product;
        holder.textViewName.setText(product.getProductName());
        String mrpString = "₹ " + String.valueOf(product.getMrp());
        holder.mrp.setText(mrpString);
        holder.mrp.setPaintFlags(holder.mrp.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        String priceString = "₹ "+String.valueOf(product.getPrice());
        holder.price.setText(priceString);
        Picasso.with(mContext)
                .load("https://rjtmobile.com/grocery/images/"+product.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
