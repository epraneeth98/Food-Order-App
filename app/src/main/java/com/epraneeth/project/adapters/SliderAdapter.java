package com.epraneeth.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epraneeth.project.viewHolders.SliderViewHolder;
import com.epraneeth.project.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import static com.epraneeth.project.activities.MainActivity.slider_image_text;
import static com.epraneeth.project.activities.MainActivity.slider_images_list;

public class SliderAdapter extends SliderViewAdapter<SliderViewHolder> {
    private Context mContext;

    public SliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_slider_view, null);
        return new SliderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        viewHolder.textView.setText(slider_image_text[position]);
        viewHolder.imageView.setImageResource(slider_images_list[position]);
    }

    @Override
    public int getCount() {
        return 4;//mList.size();
    }
}
