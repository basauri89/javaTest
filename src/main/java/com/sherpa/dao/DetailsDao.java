package com.sherpa.dao;

import com.sherpa.models.Details;

import java.util.List;

public interface DetailsDao {
    void createUserDetails(Details details);

    List<Details> getDetailsForUser(int id);
}
