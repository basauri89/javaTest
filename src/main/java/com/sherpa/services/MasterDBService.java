package com.sherpa.services;

import com.sherpa.dao.MasterDaoImpl;
import com.sherpa.models.Master;

public class MasterDBService {

    private final MasterDaoImpl masterDaoImpl = new MasterDaoImpl();

    public int getExistingUserId(String userName){
        return masterDaoImpl.getExistingUser(userName);
    }

    public int createNewUser(String userName){
        Master user = new Master();
        user.setUserName(userName);
        int existingUserId = getExistingUserId(user.getUserName());
        return existingUserId == -1 ? masterDaoImpl.createUser(user) : existingUserId;
    }
}
