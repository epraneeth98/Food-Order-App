package com.epraneeth.project.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epraneeth.project.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    private int catId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        catId = 0;
        imageView = itemView.findViewById(R.id.image_view);
        textView = itemView.findViewById(R.id.text_category_name);
    }
}
