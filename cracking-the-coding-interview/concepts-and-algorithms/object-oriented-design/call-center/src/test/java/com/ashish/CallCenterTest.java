package com.ashish;

import com.ashish.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 8.2
 * <p>
 * Imagine you have a call center with three levels of employees: respondent, manager, and director.
 * An incoming telephone call must be first allocated to a respondent who is free.
 * If the respondent can't handle the call, he or she must escalate the call to a manager.
 * If the manager is not free or not able to handle it,
 * then the call should be escalated to a director.
 * Design the classes and data structures for this problem.
 * Implement a method dispatchCall() which assigns a call to the first available employee.
 * <p>
 *
 * @author Ashish Sharma on 6/6/2017.
 *         <p>
 * @since 6/6/2017.
 */
public class CallCenterTest {

    @BeforeMethod
    public void initialize() {
    }

    @Test
    public void callCenterEmployeeTest() {
        CallCenter callCenter = new CallCenter(10, 2, 1);
        Employee employee = new Respondent(callCenter);
        Employee manager = new Manager(callCenter);
        Employee director = new Director(callCenter);
        Assert.assertTrue(true);
    }

    @Test
    public void callCenterTest() {
        CallCenter callCenter = new CallCenter(10, 2, 1);
        Assert.assertTrue(true);
    }

    @Test
    public void callCenterCallTest() {
        CallCenter callCenter = new CallCenter(10, 2, 1);
        Call call = new Call();
        callCenter.receiveCall(call);
        Assert.assertTrue(true);
    }

    @Test
    public void callCenterCallTest2() {
        CallCenter callCenter = new CallCenter(1, 1, 1);
        callCenter.receiveCall(new Call());
        callCenter.receiveCall(new Call());
        Assert.assertTrue(true);
    }
}
