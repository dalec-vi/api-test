package com.visenze.example.apis.resources;

import com.google.common.base.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {


    @GET
    @Path("/hello")
    public String sayHello() {
        return "hello";
    }

    @POST
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@FormParam("name") Optional<String> name) {
        if(name.isPresent()) {
            return "hello :" + name.get();
        }
        return "hello";
    }
}
