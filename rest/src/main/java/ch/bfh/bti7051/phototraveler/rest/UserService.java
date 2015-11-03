package ch.bfh.bti7051.phototraveler.rest;

import javax.ws.rs.*;

/**
 * Created by webel3 on 03.11.2015.
 */
@Path(value = "/user")
@Consumes("application/json")
@Produces("application/json")
public class UserService {

    @GET
    public String getUser() {
        return "";
    }

    @POST
    @Path(value = "login")
    public boolean login() {
        return false;
    }
}
