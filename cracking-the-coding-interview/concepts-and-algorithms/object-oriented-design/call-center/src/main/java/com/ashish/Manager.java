package com.ashish;

/**
 * Created by Ashish Sharma on 6/6/2017.
 */
public class Manager extends Employee {
    public Manager(CallCenter callCenter) {
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
            getCallCenter().getCallQueueManager().add(this);
        }
    }

    protected void escalate() {
        if (getCallCenter().getCallQueueDirector().peek() != null) {
            Employee director = getCallCenter().getCallQueueDirector().remove();
            director.handleCall(getCall());
        } else {
            System.out.println("Manager unable to handle call, Please try again later ");
        }
    }
}
