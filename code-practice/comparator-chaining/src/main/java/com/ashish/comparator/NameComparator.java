package com.ashish.comparator;

import com.ashish.Employee;

import java.util.Comparator;

/**
 * Created by shaashis on 10/23/2015.
 */
public class NameComparator implements Comparator<Employee> {

    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
