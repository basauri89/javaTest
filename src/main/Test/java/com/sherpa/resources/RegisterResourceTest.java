package com.sherpa.resources;

import com.sherpa.resources.RegisterResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class RegisterResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(RegisterResource.class);
    }

    @Test
    public void registerUserWithNoParameters() {
        Response response = target("register/453").request().get(Response.class);
        Assert.assertTrue(400 == response.getStatus());
    }

    @Test
    public void registerUserWithOneParameter() {
        Response response = target("register/username=test").request().get(Response.class);
        Assert.assertTrue(400 == response.getStatus());
    }

    @Test
    public void registerUser() {
        Response response = target("register/username=test&postcode=48001").request().get(Response.class);
        Assert.assertTrue(200 == response.getStatus());
    }


}