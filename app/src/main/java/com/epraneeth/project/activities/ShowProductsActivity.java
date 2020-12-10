package com.epraneeth.project.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.epraneeth.project.R;
import com.epraneeth.project.adapters.ProductsFragmentAdapter;
import com.epraneeth.project.classes.CategoryResponse;
import com.epraneeth.project.classes.Product;
import com.epraneeth.project.classes.ProductResponse;
import com.epraneeth.project.classes.SubCategory;
import com.epraneeth.project.classes.SubCategoryResponse;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

public class ShowProductsActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ProductsFragmentAdapter productsFragmentAdapter;
    ProductResponse productResponse;
    ArrayList<Product> productArrayList = new ArrayList<>();
    SubCategoryResponse subCategoryResponse;
    ArrayList<SubCategory> subCategoryArrayList = new ArrayList<>();
    int catId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);

        init();
    }

    private void init() {
        Intent intent = getIntent();
        catId = intent.getIntExtra("catId", 888);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                "https://grocery-second-app.herokuapp.com/api/products/",
                response -> {
                    Gson gson = new GsonBuilder().create();
                    productResponse = gson.fromJson(response, ProductResponse.class);
                    productArrayList.addAll(productResponse.getData());
                    Log.d("xyz", "K:  "+String.valueOf(productArrayList.size()));
                    Log.d("xyz","C:  "+productArrayList.get(0).getProductName());
                    Log.d("xyz","Success in ShowProductsActivity!");
                },
                error -> {
                    Log.d("xyz","Error in Show Products Activity-stringRequest");
                }
        );
        StringRequest stringRequest2 = new StringRequest(
                Request.Method.GET,
                "https://grocery-second-app.herokuapp.com/api/subcategory/",
                response -> {
                    Gson gson = new GsonBuilder().create();
                    subCategoryResponse = gson.fromJson(response, SubCategoryResponse.class);
                    subCategoryArrayList.addAll(subCategoryResponse.getData());
                    productsFragmentAdapter.setData(productArrayList, subCategoryArrayList);
                    Log.d("xyz","Success in stringRequest2");
                    viewPager.setAdapter(productsFragmentAdapter);
                    tabLayout.setupWithViewPager(viewPager);
                },
                error -> {
                    Log.d("xyz","Error in Show Products Activity-stringRequest2");
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest2);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        productsFragmentAdapter =
                new ProductsFragmentAdapter(
                        getSupportFragmentManager(),
                        productArrayList,
                        catId);
        Log.d("xyz", "E:"+String.valueOf(productArrayList.size()));
        Log.d("xyz", "F:"+String.valueOf(catId));


    }


}