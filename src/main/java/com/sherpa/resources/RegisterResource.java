package java.com.sherpa.resources;

import java.com.sherpa.models.Details;
import java.com.sherpa.models.GeonamesResponse;
import java.com.sherpa.models.Master;
import java.com.sherpa.services.DetailsDBService;
import java.com.sherpa.services.GeonamesService;
import java.com.sherpa.services.MasterDBService;

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

    private MasterDBService masterService = new MasterDBService();

    private DetailsDBService detailsService = new DetailsDBService();

    private GeonamesService geonames = new GeonamesService();

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

        //First of all get the city form postcode
        GeonamesResponse response = geonames.getCityFromPostCode(postCode);

        if (response.getPostalCodes().isEmpty()) return Response.status(Response.Status.CONFLICT).build();

        //Create user and insert in the database (Service will return existing user ID if it already exists)
        Master user = new Master();
        user.setUserName(userName);
        int userID = masterService.createNewUser(user);

        Details details = new Details();
        details.setCity(response.getCityFromFirstEntry());
        details.setPostCode(postCode);
        details.setUserID(userID);

        detailsService.createDetails(details);

        return Response.ok().build();
    }
}
