package com.sherpa.dao;

import com.sherpa.models.Master;

public interface MasterDao {
    int createUser(Master master);
    int getExistingUser(String userName);
}
