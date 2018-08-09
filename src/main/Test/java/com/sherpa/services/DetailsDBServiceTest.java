package com.sherpa.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class DetailsDBServiceTest {

    private DetailsDBService detailsDBService;
    @Before
    public void setUp() throws Exception {
        detailsDBService = new DetailsDBService();
    }

    @Test
    public void createDetails() {
        detailsDBService.createDetails("491290", 20, "Wakanda");
        Assert.assertFalse(detailsDBService.getDetailsForUserID(20).isEmpty());

    }
}