package com.ashish.com.ashish.call_center;

/**
 * Created by Ashish Sharma on 6/6/2017.
 */
public class Director extends Employee {

    public Director(CallCenter callCenter) {
        super(callCenter);
    }

    public void handleCall(Call call) {
        setCall(call);
        if (getEmployeeStatus() == EmployeeStatus.Busy) {
            escalate();
        } else {
            setEmployeeStatus(EmployeeStatus.Busy);
            getCall().callHandled(this);
            setEmployeeStatus(EmployeeStatus.Free);
            getCallCenter().getCallQueueDirector().add(this);
        }

    }

    public void escalate() {
        System.out.println("Director unable to handle call, Please try again later ");
    }
}
