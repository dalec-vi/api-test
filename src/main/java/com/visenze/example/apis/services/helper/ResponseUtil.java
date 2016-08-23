package com.visenze.example.apis.services.helper;

import java.util.Map;

/**
 * Created by dalec on 22/8/16.
 */
public class ResponseUtil {

    public static void addStockInfo(String type, int qty, Map<String, String>purchaseMap){

        if (type.equals("eggs")) {
            purchaseMap.put("eggs_stock", Integer.toString(qty));
        } else if (type.equals("milk")) {
            purchaseMap.put("milk_stock", Integer.toString(qty));
        }
    }

    public static void addErrorState(Map<String, String>purchaseMap, boolean state){
        if(state){
            purchaseMap.put("error", "1");
        }
        else{
            purchaseMap.put("error", "0");
        }
    }

    public static void addErrMsg(Map<String, String>purchaseMap, int errCode){
        purchaseMap.put("err_code", Integer.toString(errCode));
        switch(errCode){
            case 101:
                purchaseMap.put("err_msg", "Quantity should be positive");
                break;
            case 100:
                purchaseMap.put("err_msg", "Invalid param");
                break;
        }
    }

    public static void addPurchaseState(int qtyBought, Map<String, String> purchaseMap){
        if(qtyBought > 0){
            purchaseMap.put("status", "1");
        }
        else{
            purchaseMap.put("status", "0");
            purchaseMap.put("status_msg", "Insufficient Quantity");
        }

        purchaseMap.put("qty_bought", Integer.toString(qtyBought));
    }

    public static boolean paramCheck(int qty, Map<String, String> purchaseMap){
        if (qty <= 0) {
            ResponseUtil.addErrorState(purchaseMap, true);
            ResponseUtil.addErrMsg(purchaseMap, 101);
            return false;
        }
        return true;
    }
}
