package com.epraneeth.project.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epraneeth.project.R;
import com.epraneeth.project.activities.ShowProductsActivity;
import com.epraneeth.project.classes.Category;
import com.epraneeth.project.viewHolders.CategoryViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    Context mContext;
    ArrayList<Category> mList = new ArrayList<>();

    public CategoryAdapter(Context mContext, ArrayList<Category> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setData(ArrayList<Category> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.category_row_design, parent, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mList.get(position);
        holder.textView.setText(category.getCatName());
        holder.setCatId(category.getCatId());
        Log.d("abc", category.getCatImage());
        Picasso.with(mContext).
                load("https://rjtmobile.com/grocery/images/"+category.getCatImage()).
                into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("abcd", String.valueOf(holder.getCatId()));
                Intent intent = new Intent(mContext, ShowProductsActivity.class);
                intent.putExtra("catId", holder.getCatId());
                mContext.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

}
