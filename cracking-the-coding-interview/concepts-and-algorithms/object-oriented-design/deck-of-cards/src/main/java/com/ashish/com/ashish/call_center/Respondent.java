package com.ashish.com.ashish.call_center;

/**
 * Created by shshaash on 6/6/2017.
 */
public class Respondent extends Employee {
    public Respondent(CallCenter callCenter) {
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
            getCallCenter().getCallQueueRespondent().add(this);
        }
    }

    protected void escalate() {
        if (getCallCenter().getCallQueueManager().peek() != null) {
            Employee manager = getCallCenter().getCallQueueManager().remove();
            manager.handleCall(getCall());
        } else {
            System.out.println("Respondent unable to handle call, Please try again later ");
        }
    }
}
