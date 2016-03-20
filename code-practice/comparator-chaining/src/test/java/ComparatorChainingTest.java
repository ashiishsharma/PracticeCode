import com.ashish.Employee;
import com.ashish.comparator.AgeComparator;
import com.ashish.comparator.NameComparator;
import com.ashish.comparator.SalaryComparator;
import com.ashish.comparator.chain.ComparatorChain;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ashish Sharma
 *         on 10/23/2015.
 */
public class ComparatorChainingTest {


    @BeforeMethod
    public void init() {

    }

    @Test
    public void testComparatorChaining() {

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("Ram", 1, 5000, 20));
        employeeList.add(new Employee("Ram", 2, 2000, 10));
        employeeList.add(new Employee("Sita", 3, 2500, 15));
        employeeList.add(new Employee("Geeta", 4, 2600, 17));
        employeeList.add(new Employee("Ramesh", 5, 6000, 25));
        employeeList.add(new Employee("Suresh", 6, 4500, 23));

        ComparatorChain comparatorChain = new ComparatorChain(new NameComparator(), new AgeComparator(), new SalaryComparator());

        Collections.sort(employeeList, comparatorChain);

        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}
