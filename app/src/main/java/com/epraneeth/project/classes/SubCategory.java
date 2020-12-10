package com.epraneeth.project.classes;

public class SubCategory {
    private int catId;
    private int subId;
    private String subName;

    public SubCategory(int catId, int subId, String subName) {
        this.catId = catId;
        this.subId = subId;
        this.subName = subName;
    }

    public SubCategory(){
        catId = 99999;
        subId = 99999;
        subName = "Temp Name in SubCategory.java";
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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
