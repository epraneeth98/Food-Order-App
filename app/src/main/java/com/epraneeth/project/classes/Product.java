package com.epraneeth.project.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable {
    private String productName;
    private String description;
    private String image;
    private float price;
    private float mrp;
    private int catId;
    private int subId;

    public Product(){
        this.productName = "";
        this.description = "";
        this.image = "";
        this.price = 999;
        this.mrp = 777;
        this.catId = 0;
        this.subId = 0;
    }

    public Product(String productName, String description, String image, float price, float mrp, int catId, int subId) {
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.mrp = mrp;
        this.catId = catId;
        this.subId = subId;
    }

    protected Product(Parcel in) {
        productName = in.readString();
        description = in.readString();
        image = in.readString();
        price = in.readFloat();
        mrp = in.readFloat();
        catId = in.readInt();
        subId = in.readInt();
    }


    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeFloat(price);
        dest.writeFloat(mrp);
        dest.writeInt(catId);
        dest.writeInt(subId);
    }
}
