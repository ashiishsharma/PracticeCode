package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Stream;

public class StreamIteratorTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testStreamIterator() {
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "a", "b", "c", "d");

        Stream stringStream = stringList.stream();

        Iterator iterator = stringStream.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("######################");
        stringStream = stringList.stream();

        Spliterator spliterator = stringStream.spliterator();

        while (spliterator.tryAdvance((n) -> System.out.println(n))) ;
    }

    @Test
    public void testSpliterator() {
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "a", "b", "c", "d");
        Stream stringStream = stringList.stream();
        Spliterator spliterator = stringStream.spliterator();
        Spliterator spliterator2 = spliterator.trySplit();

        if (spliterator2 != null) {
            System.out.println("Output from second spliterator");
            spliterator2.forEachRemaining((n) -> System.out.println(n));
        }

        System.out.println("Output from first spliterator");
        spliterator.forEachRemaining((n)-> System.out.println(n));
    }
}
