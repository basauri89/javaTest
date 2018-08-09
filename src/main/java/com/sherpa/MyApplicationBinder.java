package com.sherpa;

import com.sherpa.services.DetailsDBService;
import com.sherpa.services.GeonamesService;
import com.sherpa.services.MasterDBService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(DetailsDBService.class).to(DetailsDBService.class);
        bind(MasterDBService.class).to(MasterDBService.class);
        bind(GeonamesService.class).to(GeonamesService.class);
    }
}
