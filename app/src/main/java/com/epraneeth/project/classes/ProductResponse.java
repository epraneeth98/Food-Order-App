package com.epraneeth.project.classes;

import java.util.ArrayList;

public class ProductResponse {
    private boolean error;
    private int count;
    private ArrayList<Product> data;

    public ProductResponse(boolean error, int count, ArrayList<Product> data) {
        this.error = error;
        this.count = count;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Product> getData() {
        return data;
    }

    public void setData(ArrayList<Product> data) {
        this.data = data;
    }
}
