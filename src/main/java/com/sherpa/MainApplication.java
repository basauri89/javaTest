package java.com.sherpa;

import org.glassfish.jersey.server.ResourceConfig;

public class MainApplication extends ResourceConfig {
    public MainApplication() {
        register(new MyApplicationBinder());
        packages(true, "com.sherpa");
    }
}
