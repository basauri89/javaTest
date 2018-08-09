package com.sherpa;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MainApplication extends ResourceConfig {
    public MainApplication() {
        register(new MyApplicationBinder());
        packages(true, "com.sherpa");
    }
}
