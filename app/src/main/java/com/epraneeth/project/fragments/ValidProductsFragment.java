package com.epraneeth.project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epraneeth.project.R;
import com.epraneeth.project.adapters.ProductAdapter;
import com.epraneeth.project.classes.Product;

import java.util.ArrayList;

public class ValidProductsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private ArrayList<Product> mParam1 = new ArrayList<>();

    public ValidProductsFragment() {
        // Required empty public constructor
    }

    public static ValidProductsFragment newInstance(ArrayList<Product> validProductArrayList) {
        ValidProductsFragment fragment = new ValidProductsFragment();
        Bundle args = new Bundle();
        Log.d("xyz","ZZ: "+validProductArrayList.size());
        args.putParcelableArrayList(ARG_PARAM1, validProductArrayList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelableArrayList(ARG_PARAM1);
            Log.d("bcd", String.valueOf(mParam1.get(0).getCatId()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_valid_products, container, false);
        Log.d("xyz","In OnCreateView in ValidProductsFragment");

        RecyclerView recyclerView = v.findViewById(R.id.recycler_view_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter( new ProductAdapter(getActivity(), mParam1));

        return v;
    }
}