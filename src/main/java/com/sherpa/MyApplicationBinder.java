package java.com.sherpa;

import java.com.sherpa.services.DetailsDBService;
import java.com.sherpa.services.GeonamesService;
import java.com.sherpa.services.MasterDBService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(DetailsDBService.class).to(DetailsDBService.class);
        bind(MasterDBService.class).to(MasterDBService.class);
        bind(GeonamesService.class).to(GeonamesService.class);
    }
}
