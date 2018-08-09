package com.sherpa.services;

import com.sherpa.models.GeonamesResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GeonamesService {
    private static final String USERNAME = "basauri89";
    private static final String ENDPOINT = "http://api.geonames.org/postalCodeSearchJSON";
    private Client client;
    private WebTarget target;

    public GeonamesService() {
        this.client = ClientBuilder.newClient();
        target = client.target(ENDPOINT)
                .queryParam("maxRows", "10")
                .queryParam("username", USERNAME);
    }

    public GeonamesResponse getCityFromPostCode(String postCode) {
        return target.queryParam("postalcode", postCode)
                .request(MediaType.APPLICATION_JSON)
                .get(GeonamesResponse.class);
    }
}
