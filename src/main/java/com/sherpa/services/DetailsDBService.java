package java.com.sherpa.services;

import java.com.sherpa.dao.DetailsDaoImpl;
import java.com.sherpa.models.Details;

public class DetailsDBService {

    private final DetailsDaoImpl detailsDao = new DetailsDaoImpl();

    public void createDetails(Details details){
        detailsDao.createUserDetails(details);
    }
}
