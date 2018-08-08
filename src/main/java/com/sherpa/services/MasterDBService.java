package java.com.sherpa.services;

import java.com.sherpa.dao.MasterDaoImpl;
import java.com.sherpa.models.Master;

public class MasterDBService {

    private final MasterDaoImpl masterDaoImpl = new MasterDaoImpl();

    public int getExistingUserId(String userName){
        return masterDaoImpl.getExistingUser(userName);
    }

    public int createNewUser(Master master){
        int existingUserId = getExistingUserId(master.getUserName());
        return existingUserId == -1 ? masterDaoImpl.createUser(master) : existingUserId;
    }
}
