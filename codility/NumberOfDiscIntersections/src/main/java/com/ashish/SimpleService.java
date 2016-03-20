package com.ashish;

import java.io.IOException;

public interface SimpleService {
    public void printNameId();

    public void checkName();

    public String sayHello(String message);

    public void myName() throws IOException;
}