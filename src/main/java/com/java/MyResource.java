package com.java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "register" path)
 */
@Path("register")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/JSON" media type.
     *
     * @return Simple JSON object when successful
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        return Response.ok("Success").build();
    }
}
