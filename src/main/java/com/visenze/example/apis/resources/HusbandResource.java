package com.visenze.example.apis.resources;

import com.visenze.example.apis.entities.Husband;
import com.visenze.example.apis.services.StoreItemService;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dejun on 18/9/15.
 */
@Path("/husband")
@Produces(MediaType.APPLICATION_JSON)
public class HusbandResource {

    private StoreItemService storeItemService;
    private Husband husband;

    public HusbandResource(StoreItemService storeItemService) {
        this.storeItemService = storeItemService;
        this.husband = new Husband();
    }

    @GET
    @Path("/milkcount")
    public Map<String, String> getMilkCount() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("error", "0");
        response.put("milk", Integer.toString(this.husband.getMilkCartons().getCount()));
        return response;
    }

    @GET
    @Path("/eggcount")
    public Map<String, String> getEggCount() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("error", "0");
        response.put("eggs", Integer.toString(this.husband.getEggs().getCount()));
        return response;
    }

    @GET
    @Path("/shop")
    public Map<String, Integer> shop() {
        Map<String, Integer> purchase = new HashMap<String, Integer>();

        this.husband = storeItemService.buyItemsForHusband(husband);
        purchase.put("error", 0);
        purchase.put("eggs_bought", husband.getEggs().getCount());
        purchase.put("milk_bought", husband.getMilkCartons().getCount());
        return purchase;
    }

}
