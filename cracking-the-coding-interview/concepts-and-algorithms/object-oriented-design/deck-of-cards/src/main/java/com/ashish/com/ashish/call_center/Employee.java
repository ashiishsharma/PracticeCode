package com.ashish.com.ashish.call_center;

/**
 * Created by Ashish Sharma on 6/6/2017.
 */
public abstract class Employee {

    private CallCenter callCenter;
    private EmployeeStatus employeeStatus;
    private Call call;

    public Employee(CallCenter callCenter) {
        this.callCenter = callCenter;
        this.employeeStatus = EmployeeStatus.Free;
    }

    public abstract void handleCall(Call call);

    protected abstract void escalate();

    protected CallCenter getCallCenter() {
        return callCenter;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }
}
