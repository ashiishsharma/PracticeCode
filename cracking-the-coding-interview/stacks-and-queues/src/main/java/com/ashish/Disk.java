package com.ashish;

/**
 * @author Ashish Sharma on 10/12/2016.
 */
public class Disk {
    private final String diskName;
    private final int diskNumber;

    public Disk(String diskName, int diskNumber) {
        this.diskName = diskName;
        this.diskNumber = diskNumber;
    }

    public String getDiskName() {
        return diskName;
    }

    public int getDiskNumber() {
        return diskNumber;
    }
}
