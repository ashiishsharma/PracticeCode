package com.ashish.com.ashish.call_center;

import com.ashish.com.ashish.call_center.Call;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Ashish Sharma on 6/6/2017.
 */
public class CallCenter {

    private List<Employee> respondentList;
    private List<Employee> managerList;
    private List<Employee> directorList;

    public Queue<Employee> getCallQueueRespondent() {
        return callQueueRespondent;
    }

    public Queue<Employee> getCallQueueManager() {
        return callQueueManager;
    }

    public Queue<Employee> getCallQueueDirector() {
        return callQueueDirector;
    }

    private Queue<Employee> callQueueRespondent;
    private Queue<Employee> callQueueManager;
    private Queue<Employee> callQueueDirector;

    public CallCenter(int respondentCount, int managerCount, int directorCount) {
        respondentList = new ArrayList<Employee>();
        initializeRespondents(respondentCount);
        managerList = new ArrayList<Employee>();
        initializeManagers(managerCount);
        directorList = new ArrayList<Employee>();
        initializeDirectors(directorCount);


        callQueueRespondent = new LinkedList(respondentList);
        callQueueManager = new LinkedList(managerList);
        callQueueDirector = new LinkedList(directorList);
    }

    private void initializeDirectors(int directorCount) {
        for (int i = 0; i < directorCount; i++) {
            directorList.add(new Director(this));
        }
    }

    private void initializeManagers(int managerCount) {
        for (int i = 0; i < managerCount; i++) {
            managerList.add(new Manager(this));
        }
    }

    private void initializeRespondents(int respondentCount) {
        for (int i = 0; i < respondentCount; i++) {
            respondentList.add(new Respondent(this));
        }
    }

    public void receiveCall(Call call) {
        dispatchCall(call);
    }

    private void dispatchCall(Call call) {
        if (callQueueRespondent.peek() != null) {
            Employee employee = callQueueRespondent.remove();
            employee.handleCall(call);
        } else {
            System.out.println("Unable to handle call, Please try again later");
        }
    }
}
