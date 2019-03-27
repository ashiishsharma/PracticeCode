package com.ashish;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
    private Hashtable isVisited;
    private Queue toVisit;

    public BFSData(Person person) {
        this.isVisited = new Hashtable();
        this.toVisit = new LinkedList();
    }

    public Hashtable getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Hashtable isVisited) {
        this.isVisited = isVisited;
    }

    public Queue getToVisit() {
        return toVisit;
    }

    public void setToVisit(Queue toVisit) {
        this.toVisit = toVisit;
    }

    public boolean isFinished() {
        return false;
    }
}


