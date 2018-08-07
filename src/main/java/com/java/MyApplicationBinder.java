package com.java;

import com.java.services.DetailsDBService;
import com.java.services.GeonamesService;
import com.java.services.MasterDBService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(DetailsDBService.class).to(DetailsDBService.class);
        bind(MasterDBService.class).to(MasterDBService.class);
        bind(GeonamesService.class).to(GeonamesService.class);
    }
}
