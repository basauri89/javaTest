package java.com.sherpa.dao;

import java.com.sherpa.models.Master;

public interface MasterDao {
    int createUser(Master master);
    int getExistingUser(String userName);
}
