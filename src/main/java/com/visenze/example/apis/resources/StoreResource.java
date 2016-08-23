package com.visenze.example.apis.resources;

import com.google.common.base.Optional;

import com.visenze.example.apis.services.StoreItemService;
import com.visenze.example.apis.services.helper.ResponseUtil;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dejun on 18/9/15.
 */
@Path("/store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {

    private StoreItemService storeItemService;

    public StoreResource(StoreItemService storeItemService) {
        this.storeItemService = storeItemService;
    }

    @GET
    @Path("/hasmilk")
    public Map<String, String> hasMilk() {
        Map<String, String> purchaseMap = new HashMap<String, String>();
        ResponseUtil.addErrorState(purchaseMap, false);
        ResponseUtil.addStockInfo("milk", storeItemService.getMilkCartonCount(), purchaseMap);
        return purchaseMap;
    }

    @GET
    @Path("/haseggs")
    public Map<String, String> hasEggs() {
        Map<String, String> purchaseMap = new HashMap<String, String>();
        ResponseUtil.addErrorState(purchaseMap, false);
        ResponseUtil.addStockInfo("eggs", storeItemService.getEggCount(), purchaseMap);
        return purchaseMap;
    }

    @POST
    @Path("/buymilk")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map<String, String> buyMilk(@FormParam("quantity") Optional<Integer> quantity) {
        Map<String, String> purchaseMap = new HashMap<String, String>();

        if (quantity.get() < 0) {
            ResponseUtil.addErrorState(purchaseMap, true);
            ResponseUtil.addErrMsg(purchaseMap, 101);
            return purchaseMap;
        }

        int qtyBought = storeItemService.buyMilk(quantity.get());

        ResponseUtil.addErrorState(purchaseMap, false);
        ResponseUtil.addPurchaseState(qtyBought, purchaseMap);
        ResponseUtil.addStockInfo("milk", storeItemService.getMilkCartonCount(), purchaseMap);

        return purchaseMap;
    }

    @POST
    @Path("/buyeggs")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map<String, String> buyEggs(@FormParam("quantity") Optional<Integer> quantity) {
        Map<String, String> purchaseMap = new HashMap<String, String>();
        if (quantity.get() < 0) {
            ResponseUtil.addErrorState(purchaseMap, true);
            ResponseUtil.addErrMsg(purchaseMap, 101);
            return purchaseMap;
        }

        int qtyBought = storeItemService.buyEggs(quantity.get());

        ResponseUtil.addErrorState(purchaseMap, false);
        ResponseUtil.addPurchaseState(qtyBought, purchaseMap);
        ResponseUtil.addStockInfo("eggs", storeItemService.getEggCount(), purchaseMap);

        return purchaseMap;
    }
}
