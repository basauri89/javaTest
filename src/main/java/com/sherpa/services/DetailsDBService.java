package com.sherpa.services;

import com.sherpa.dao.DetailsDaoImpl;
import com.sherpa.models.Details;

import java.util.List;

public class DetailsDBService {

    private final DetailsDaoImpl detailsDao = new DetailsDaoImpl();

    public List<Details> getDetailsForUserID(int id){
        return detailsDao.getDetailsForUser(id);
    }

    public void createDetails(String postCode, int userId, String city){
        Details details = new Details();
        details.setCity(city);
        details.setPostCode(postCode);
        details.setUserID(userId);
        detailsDao.createUserDetails(details);
    }
}
