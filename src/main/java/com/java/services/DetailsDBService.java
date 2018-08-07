package com.java.services;

import com.java.dao.DetailsDaoImpl;
import com.java.models.Details;

import javax.ejb.Stateless;

public class DetailsDBService {

    private final DetailsDaoImpl detailsDao = new DetailsDaoImpl();

    public void createDetails(Details details){
        detailsDao.createUserDetails(details);
    }
}
