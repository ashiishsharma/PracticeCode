package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceTest {

    @BeforeMethod
    public void init() {
    }

    @Test
    public void testStreamReduce() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        Optional<Integer> integerProduct = integerList.stream().reduce((a, b) -> (a * b));
        if (integerProduct.isPresent()) {
            System.out.println("4! = " + integerProduct.get());
        }

        // The operation is like ((((2*1)*2)*3)*4) = 48
        int product = integerList.stream().reduce(2, (a, b) -> (a * b));
        System.out.println("Product as int: " + product);

        int evenProduct = integerList.stream().reduce(1, (a, b) -> {
            if (b % 2 == 0) {
                return a * b;
            } else {
                return a;
            }
        });

        System.out.println("Even Product as int: " + evenProduct);
    }

    @Test
    public void testParallelStreamReduce() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        int integerProduct = integerList.parallelStream().
                reduce(1, (a, b) -> (a * b), (a, b) -> (a * b));
        System.out.println("4! = " + integerProduct);

        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        double productOfSquareRoots = doubleList.parallelStream().
                reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> (a * b));
        System.out.println("ProductOfSquareRoots = " + productOfSquareRoots);
    }


}
