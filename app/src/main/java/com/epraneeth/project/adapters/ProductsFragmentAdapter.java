package com.epraneeth.project.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.epraneeth.project.classes.Product;
import com.epraneeth.project.classes.SubCategory;

import java.util.ArrayList;
import java.util.Vector;

import static com.epraneeth.project.fragments.ValidProductsFragment.newInstance;

public class ProductsFragmentAdapter extends FragmentPagerAdapter {

    private Vector<Integer> subCategories = new Vector<>();
    ArrayList<Product> productArrayList = new ArrayList<>();
    ArrayList<SubCategory> subCategoryArrayList = new ArrayList<>();
    int catId;

    public ProductsFragmentAdapter(@NonNull FragmentManager fm, ArrayList<Product> productArrayList, int catId) {
        super(fm);
        this.productArrayList = productArrayList;
        this.catId = catId;
        this.subCategories = getVectorSubId();
        Log.d("xyz","Just entered ProductsFragmentAdapter!");
        Log.d("xyz", "A: "+String.valueOf(subCategories.size()));
        Log.d("xyz", "B: "+String.valueOf(productArrayList.size()));
        Log.d("xyz", "catId: "+String.valueOf(catId));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        int subId = subCategories.get(position);
        Log.d("xyz", "D: "+String.valueOf(subCategories.size()));
        Log.d("xyz", "H: "+String.valueOf(subId));
        Log.d("xyz", "M: "+String.valueOf(catId));
        ArrayList<Product> validProductArrayList = new ArrayList<>();
        for(int i=0; i<productArrayList.size(); i++){
            if(productArrayList.get(i).getSubId()==subId && productArrayList.get(i).getCatId()==catId){
                validProductArrayList.add(productArrayList.get(i));
            }
        }
        Log.d("xyz","Valid product Array List size: "+ validProductArrayList.size());
        return newInstance(validProductArrayList);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        int subId = subCategories.get(position);
        for(int i=0; i<subCategoryArrayList.size(); i++){
            SubCategory subCategory = subCategoryArrayList.get(i);
            if(subCategory.getCatId()==catId && subCategory.getSubId()==subId){
                return subCategory.getSubName();
            }
        }
        return "Cat:"+String.valueOf(catId)+" Sub:"+String.valueOf(subId);
    }

    @Override
    public int getCount() {
        Log.d("xyz", "G:"+String.valueOf(subCategories.size()));
        return subCategories.size();
    }

    public void setData(ArrayList<Product> productArrayList, ArrayList<SubCategory> subCategoryArrayList) {
        this.productArrayList = productArrayList;
        this.subCategoryArrayList = subCategoryArrayList;
        notifyDataSetChanged();
        this.subCategories = getVectorSubId();
        Log.d("xyz", "New:"+String.valueOf(productArrayList.size()));
        Log.d("xyz", "New2:"+String.valueOf(subCategories.size()));
        Log.d("xyz", "New3:"+String.valueOf(catId));
    }

    private  Vector<Integer> getVectorSubId(){
        Vector<Integer> subCategories = new Vector<>();
        for(int i=0; i<productArrayList.size(); i++){
            if(productArrayList.get(i).getCatId()==catId){
                boolean is_present = false;
                for(int j=0; j<subCategories.size(); j++){
                    if(productArrayList.get(i).getSubId()==subCategories.get(j)){
                       is_present = true;
                       break;
                    }
                }
                if(!is_present){
                    subCategories.add(productArrayList.get(i).getSubId());
                }
            }
        }
        return subCategories;
    }
}
