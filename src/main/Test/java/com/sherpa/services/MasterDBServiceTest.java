package com.sherpa.services;

import com.sherpa.models.Master;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@Transactional
public class MasterDBServiceTest {

    private MasterDBService masterDBService;

    @Before
    public void setUp(){
        masterDBService = new MasterDBService();
    }

    @Test
    public void createNewUser() {
        Master m = new Master();
        m.setUserName("test");

        int userID = masterDBService.createNewUser(m.getUserName());

        int createdID = masterDBService.getExistingUserId(m.getUserName());

        Assert.assertTrue(userID == createdID);
    }

    @Test
    public void getExistingUserId() {
        //if no user found return should be -1
        Assert.assertTrue(masterDBService.getExistingUserId("test") != -1);
    }

    @Test
    public void getNonExistingUserId() {
        //if no user found return should be -1
        Assert.assertTrue(masterDBService.getExistingUserId("Agapito") == -1);
    }
}