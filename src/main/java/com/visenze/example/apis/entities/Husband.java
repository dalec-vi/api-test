package com.visenze.example.apis.entities;

/**
 * Created by dalec on 22/8/16.
 */
public class Husband {
    private StoreItem milkCartons;
    private StoreItem eggs;

    public Husband() {
        milkCartons = new StoreItem("milk", 0);
        eggs = new StoreItem("egg", 0);
    }

    public StoreItem getMilkCartons() {
        return this.milkCartons;
    }

    public StoreItem getEggs() {
        return this.eggs;
    }
}
