package com.ashish.comparator;

import com.ashish.Employee;

import java.util.Comparator;

/**
 * Created by shaashis on 10/23/2015.
 */
public class AgeComparator implements Comparator<Employee> {
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}
