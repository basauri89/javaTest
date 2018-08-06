package com.java.services;

import com.java.dao.MasterDaoImpl;
import com.java.models.Master;

public class MasterDBService {

    private final MasterDaoImpl masterDaoImpl = new MasterDaoImpl();

    public int getExistingUserId(Master master){
        return masterDaoImpl.getExistingUser(master);
    }

    public int createNewUser(Master master){
        int existingUserId = getExistingUserId(master);
        return existingUserId != -1 ? masterDaoImpl.createUser(master) : existingUserId;
    }
}
