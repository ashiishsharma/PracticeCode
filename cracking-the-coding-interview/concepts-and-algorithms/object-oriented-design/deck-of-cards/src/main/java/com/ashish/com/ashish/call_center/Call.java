package com.ashish.com.ashish.call_center;

/**
 * Created by shshaash on 6/6/2017.
 */
public class Call {

    public void callHandled(Employee employee) {
        String employeeType = employee.getClass().getSimpleName();
        System.out.println("Call handled by " + employeeType);
        System.out.println("Call handled by " + employeeType + " .");
        System.out.println("Call handled by " + employeeType + " ..");
        System.out.println("Call handled by " + employeeType + " ...");
        System.out.println("Call handled by " + employeeType + " ....");
        System.out.println("Call finished by " + employeeType);
    }
}
