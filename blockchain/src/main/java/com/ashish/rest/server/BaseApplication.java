package com.ashish.rest.server;

import com.ashish.rest.resource.BlockChainResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


public class BaseApplication extends Application {

    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();

    public BaseApplication() {
        // ADD YOUR RESTFUL RESOURCES HERE
        this.singletons.add(new BlockChainResource());
    }

    public Set<Class<?>> getClasses() {
        return this.empty;
    }

    public Set<Object> getSingletons() {
        return this.singletons;
    }
}

