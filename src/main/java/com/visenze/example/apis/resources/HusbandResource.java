package com.visenze.example.apis.resources;

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

    @GET
    @Path("/milkcount")
    public int getMilkCount() {
        return milkCartonCount;
    }

    @GET
    @Path("/eggcount")
    public int getEggCount() {
        return eggCount;
    }

    private int milkCartonCount = 0;
    private int eggCount = 0;
}
