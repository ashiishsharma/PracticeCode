package com.ashish;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Ashish Sharma
 *         Created on 6/28/2015.
 */
@Component
public class SimpleServiceImpl implements SimpleService {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printNameId() {
        System.out.println("SimpleService : Method printNameId() : My name is " + name
                + " and my id is " + id);
    }

    public void checkName() {
        if (name.length() < 20) {
            throw new IllegalArgumentException();
        }
    }

    public String sayHello(String message) {
        System.out.println("SimpleService : Method sayHello() : Hello! " + message);
        return message;
    }


    public void myName() throws IOException {
        System.out.println("Ashish Sharma is great");
        publicPrint();
    }

    @Retry(attempts = 10, types = IOException.class, delay = 50, randomize = false)
    private void publicPrint() throws IOException {
        System.out.println("From publicPrint");
        throw new IOException();
    }
}