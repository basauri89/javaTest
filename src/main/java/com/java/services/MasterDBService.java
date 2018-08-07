package com.java.services;

import com.java.dao.MasterDaoImpl;
import com.java.models.Master;

import javax.ejb.Stateless;

public class MasterDBService {

    private final MasterDaoImpl masterDaoImpl = new MasterDaoImpl();

    public int getExistingUserId(String userName){
        return masterDaoImpl.getExistingUser(userName);
    }

    public int createNewUser(Master master){
        int existingUserId = getExistingUserId(master.getUserName());
        return existingUserId != -1 ? masterDaoImpl.createUser(master) : existingUserId;
    }
}
