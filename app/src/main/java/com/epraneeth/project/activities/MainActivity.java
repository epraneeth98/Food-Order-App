package com.epraneeth.project.activities;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.epraneeth.project.adapters.CategoryAdapter;
import com.epraneeth.project.adapters.SliderAdapter;
import com.epraneeth.project.R;
import com.epraneeth.project.classes.Category;
import com.epraneeth.project.classes.CategoryResponse;
import com.epraneeth.project.classes.Product;
import com.epraneeth.project.classes.ProductResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SliderView sliderView;
    RecyclerView recyclerView;
    CategoryResponse categoryResponse;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categoryArrayList = new ArrayList<>();
    public static @DrawableRes
    int[] slider_images_list = new int[]{R.drawable.foodpanda_4,
            R.drawable.foodpanda_2,
            R.drawable.foodpanda_3,
            R.drawable.foodpanda_1};

    public static String[] slider_image_text = new String[]{"20% off on Mc Spicy Extra value meal", "50% off on first 3 orders!", "Exclusive Mc Donald's coupons", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                "https://grocery-second-app.herokuapp.com/api/category/",
                response -> {
                    Gson gson = new GsonBuilder().create();
                    categoryResponse = gson.fromJson(response, CategoryResponse.class);
                    categoryArrayList.addAll(categoryResponse.getData());
                    categoryAdapter.setData(categoryArrayList);
                },
                error -> Log.d("abc", "Error Buddy!")
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        sliderView = findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setScrollTimeInSec(2);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        //init2
        recyclerView = findViewById(R.id.all_categories_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        categoryAdapter = new CategoryAdapter(this, categoryArrayList);
        recyclerView.setAdapter(categoryAdapter);
    }
}