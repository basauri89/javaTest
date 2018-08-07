package com.java.services;

import com.java.models.GeonamesResponse;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GeonamesService {
    private Client client;
    private WebTarget target;

    @PostConstruct
    protected void init() {
        client = ClientBuilder.newClient();
        //query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target("http://api.openweathermap.org/data/2.5/forecast/daily")
                .queryParam("maxRows", "10")
                .queryParam("username", "basauri89");
    }

    public GeonamesResponse getCityFromPostCode(String postCode) {
        return target.queryParam("postalCode", postCode)
                .request(MediaType.APPLICATION_JSON)
                .get(GeonamesResponse.class);
    }
}
