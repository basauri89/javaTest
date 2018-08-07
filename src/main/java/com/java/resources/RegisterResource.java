package com.java.resources;

import com.java.dao.MasterDaoImpl;
import com.java.models.Details;
import com.java.models.GeonamesResponse;
import com.java.models.Master;
import com.java.services.DetailsDBService;
import com.java.services.GeonamesService;
import com.java.services.MasterDBService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "register" path)
 */
@Path("register")
public class RegisterResource {

    @Inject
    private MasterDBService masterService;

    @Inject
    private DetailsDBService detailsService;

    @Inject
    private GeonamesService geonames;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/JSON" media type.
     *
     * @return Simple JSON object when successful
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(@QueryParam("username") String userName, @QueryParam("postCode") String postCode) {

        //Invalid request
        if (userName == null || postCode == null) return Response.status(400).build();

        //User does not exist on the database
        Master user = new Master();
        user.setUserName(userName);
        int userID = masterService.createNewUser(user);

        GeonamesResponse response = geonames.getCityFromPostCode(postCode);
        Details details = new Details();
        details.setCity(response.getCity());
        details.setPostCode(postCode);
        details.setUserID(userID);

        detailsService.createDetails(details);

        return Response.ok().build();
    }
}
