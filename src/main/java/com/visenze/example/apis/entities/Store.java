package com.visenze.example.apis.entities;

/**
 * Created by dalec on 22/8/16.
 */
public class Store {
    private StoreItem milkCartons;
    private StoreItem eggs;

    public Store(int milkQty, int eggQty) {
        milkCartons = new StoreItem("milk", milkQty);
        eggs = new StoreItem("egg", eggQty);
    }

    public StoreItem getMilkCartons() {
        return this.milkCartons;
    }

    public StoreItem getEggs() {
        return this.eggs;
    }
}
