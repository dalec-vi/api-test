package com.visenze.example.apis.entities;

/**
 * Created by dalec on 22/8/16.
 */
public class StoreItem {

    private String name;

    private int count;

    public StoreItem(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
