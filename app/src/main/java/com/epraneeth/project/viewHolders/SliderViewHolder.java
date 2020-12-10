package com.epraneeth.project.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epraneeth.project.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderViewHolder extends SliderViewAdapter.ViewHolder {
    public TextView textView;
    public ImageView imageView;
    public SliderViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_on_image);
        imageView = itemView.findViewById(R.id.image_in_image_slider);
    }
}
