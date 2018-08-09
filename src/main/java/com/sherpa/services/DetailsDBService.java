package com.sherpa.services;

import com.sherpa.dao.DetailsDaoImpl;
import com.sherpa.models.Details;

public class DetailsDBService {

    private final DetailsDaoImpl detailsDao = new DetailsDaoImpl();

    public void createDetails(String postCode, int userId, String city){
        Details details = new Details();
        details.setCity(city);
        details.setPostCode(postCode);
        details.setUserID(userId);
        detailsDao.createUserDetails(details);
    }
}
