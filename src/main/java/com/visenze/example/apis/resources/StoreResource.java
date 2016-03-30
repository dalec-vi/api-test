package com.visenze.example.apis.resources;

import com.google.common.base.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by dejun on 18/9/15.
 */
@Path("/store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {
    @GET
    @Path("/hasmilk")
    public int hasMilk() {
        return 1000;
    }

    @GET
    @Path("/haseggs")
    public int hasEggs() {
        return 1000;
    }

    @POST
    @Path("/buymilk")
    @Produces(MediaType.TEXT_PLAIN)
    public int buyMilk(@FormParam("quantity") Optional<Integer> quantity) {
        return 0;
    }

    @POST
    @Path("/buyeggs")
    @Produces(MediaType.TEXT_PLAIN)
    public int buyEggs(@FormParam("quantity") Optional<Integer> quantity) {
        return 0;
    }
}
