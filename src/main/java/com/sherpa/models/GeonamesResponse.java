package com.sherpa.models;

import java.util.List;

public class GeonamesResponse {

    private List<PostalCode> postalCodes;

    public GeonamesResponse() {
    }

    public List<PostalCode> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }

    public String getCityFromFirstEntry(){
        return postalCodes.get(0).getPlaceName();
    }
}
