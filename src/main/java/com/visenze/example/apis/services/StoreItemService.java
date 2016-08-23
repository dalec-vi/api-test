package com.visenze.example.apis.services;

import com.visenze.example.apis.entities.Husband;
import com.visenze.example.apis.entities.Store;

/**
 * Created by dalec on 19/8/16.
 */
public class StoreItemService {

    private static final int milkQty = 1000;
    private static final int eggQty = 1000;
    private Store store;

    public StoreItemService() {

        store = new Store(milkQty, eggQty);
    }

    public int getMilkCartonCount() {
        return this.store.getMilkCartons().getCount();
    }

    public int getEggCount() {
        return this.store.getEggs().getCount();
    }

    public int buyMilk(int qty) {
        int milkCartonCount = getMilkCartonCount();
        if (qty <= milkCartonCount) {
            store.getMilkCartons().setCount(milkCartonCount - qty);
            return qty;
        }

        return 0;
    }

    public int buyEggs(int qty) {
        int eggCount = getEggCount();
        if (qty <= eggCount) {
            store.getEggs().setCount(eggCount - qty);
            return qty;
        }

        return 0;
    }

    public Husband buyItemsForHusband(Husband husband) {

        if (getMilkCartonCount() >= 1) {
            buyMilk(1);
            int prevCount = husband.getMilkCartons().getCount();
            husband.getMilkCartons().setCount(prevCount + 1);
        }
        if (getEggCount() >= 12) {
            buyEggs(12);
            int prevCount = husband.getEggs().getCount();
            husband.getEggs().setCount(prevCount + 12);
        }

        return husband;
    }
}
