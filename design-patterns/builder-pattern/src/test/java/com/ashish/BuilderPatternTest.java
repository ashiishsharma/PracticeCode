package com.ashish;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuilderPatternTest {

    @BeforeMethod
    public void initialize() {

    }

    @Test
    public void testBuilderPattern() {
        Computer computer = new Computer.ComputerBuilder("4GB", "200GB")
                .setGraphicsCardEnabled(true)
                .setWiFiEnabled(true)
                .build();
        Assert.assertEquals(computer.getRamSize(),"4GB");
    }
}
