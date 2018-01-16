package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamIOTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testStream() {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> stream = integerList.stream();

        Optional<Integer> minValue = stream.min(Integer::compare);

        if (minValue.isPresent()) {
            System.out.println("Minimum value " + minValue.get());
        }

        stream = integerList.stream();

        Optional<Integer> maxValue = stream.max(Integer::compare);

        if (minValue.isPresent()) {
            System.out.println("Maximum value " + maxValue.get());
        }

        Stream<Integer> sortedStream = integerList.stream().sorted();
        System.out.print("Sorted stream : ");
        sortedStream.forEach((n) -> System.out.print(n + " "));


        Stream<Integer> oddStream = integerList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.println();
        System.out.print("Odd Values : ");
        oddStream.forEach((n) -> System.out.print(n + " "));

        Stream<Integer> filteredOddStream = integerList.stream().sorted().filter((n) -> (n % 2) == 1).filter((n) -> (
                n > 5));
        System.out.println();
        System.out.print("Odd Values greater then 5: ");
        filteredOddStream.forEach((n) -> System.out.print(n + " "));
    }
}
