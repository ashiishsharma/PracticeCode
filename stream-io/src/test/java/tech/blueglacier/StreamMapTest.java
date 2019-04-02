package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testStreamMap() {
        List<Double> doubleList = Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);
        Stream<Double> squareRootStream = doubleList.stream().map((a) -> Math.sqrt(a));

        double productOfSquareRoots = squareRootStream.reduce(1.0, (a, b) -> (a * b));
        System.out.println("Product of square roots : " + productOfSquareRoots);
    }

    @Test
    public void testMapStreamFiltering() {
        List<NamePhoneEmail> namePhoneEmailList = Arrays.asList(new NamePhoneEmail("a", "1", "a@a.com"),
                new NamePhoneEmail("b", "2", "b@b.com"),
                new NamePhoneEmail("c", "3", "c@c.com"),
                new NamePhoneEmail("d", "4", "d@d.com"),
                new NamePhoneEmail("e", "5", "e@e.com"));

        System.out.println("Original values in myList: ");
        namePhoneEmailList.stream().forEach((a) -> {
            System.out.println(a.name + " " + a.phone + " " + a.email);
        });
        System.out.println();

        Stream<NamePhone> namePhoneStream = namePhoneEmailList.stream().map((a) -> new NamePhone(a.name, a.phone));

        System.out.println("List of names and phone numbers: ");
        namePhoneStream.forEach((a) -> {
            System.out.println(a.name + " " + a.phone);
        });
        System.out.println();

        Stream<NamePhone> filteredNamePhoneStream = namePhoneEmailList.stream().filter
                ((a) -> a.name.equalsIgnoreCase("a")).map((NamePhoneEmail a) -> {
            return new NamePhone(a.name, a.phone);
        });
        System.out.println("List of names and phone numbers: ");
        filteredNamePhoneStream.forEach((NamePhone a) -> {
            System.out.println(a.name + " " + a.phone);
        });
        System.out.println();
    }

    @Test
    public void getPrimitiveStreamTest() {
        List<Double> doubleList = Arrays.asList(7.49, 18.78, 10.21, 24.34, 17.89, 5.3);
        System.out.println("Original values in list : ");
        doubleList.stream().forEach((a) -> {
            System.out.print(a + " ");
        });
        System.out.println();
        IntStream intStream = doubleList.stream().mapToInt((a) -> (int) Math.ceil(a));
        System.out.println("Ceiling values in list : ");
        intStream.forEach((a) -> {
            System.out.print(a + " ");
        });
    }

    private class NamePhoneEmail {
        String name;
        String phone;
        String email;

        public NamePhoneEmail(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }

    private class NamePhone {
        String name;
        String phone;

        public NamePhone(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
