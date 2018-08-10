package com.sherpa.services;

import com.sherpa.models.GeonamesResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeonamesServiceTest {

    private GeonamesService geonamesService;

    @Before
    public void setUp() throws Exception {
        geonamesService = new GeonamesService();
    }

    @Test
    public void getCityFromPostCode() {
        GeonamesResponse response = geonamesService.getCityFromPostCode("48991");
        Assert.assertEquals("Getxo", response.getCityFromFirstEntry());

        GeonamesResponse response2 = geonamesService.getCityFromPostCode("48001");
        Assert.assertEquals("Bilbao", response2.getCityFromFirstEntry());
    }
}