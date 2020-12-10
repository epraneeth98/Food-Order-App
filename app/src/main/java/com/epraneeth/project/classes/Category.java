package com.epraneeth.project.classes;

public class Category {
        private String catImage;
        private int catId;
        private String catName;

    public Category(String catImage, int catId, String catName) {
        this.catImage = catImage;
        this.catId = catId;
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}

