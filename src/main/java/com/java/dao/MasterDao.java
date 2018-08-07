package com.java.dao;

import com.java.models.Master;

public interface MasterDao {
    int createUser(Master master);
    int getExistingUser(String userName);
}
