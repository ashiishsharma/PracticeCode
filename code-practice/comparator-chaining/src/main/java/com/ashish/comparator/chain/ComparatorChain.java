package com.ashish.comparator.chain;

import com.ashish.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ashish Sharma
 *         on 10/23/2015.
 */
public class ComparatorChain implements Comparator<Employee> {
    List<Comparator<Employee>> comparators;

    public ComparatorChain(Comparator<Employee>... comparator) {
        this.comparators = Arrays.asList(comparator);

    }

    public int compare(Employee o1, Employee o2) {
        for (Comparator<Employee> comparator : comparators) {
            int result = comparator.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
