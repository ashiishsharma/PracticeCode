package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testStreamToCollector() {
        List<StreamCollectTest.NamePhoneEmail> namePhoneEmailList = Arrays.asList(new StreamCollectTest.NamePhoneEmail("a", "1", "a@a.com"),
                new StreamCollectTest.NamePhoneEmail("b", "2", "b@b.com"),
                new StreamCollectTest.NamePhoneEmail("c", "3", "c@c.com"),
                new StreamCollectTest.NamePhoneEmail("d", "4", "d@d.com"),
                new StreamCollectTest.NamePhoneEmail("e", "5", "e@e.com"));

//        System.out.println("Original values in myList: ");
//        namePhoneEmailList.stream().forEach((a) -> {
//            System.out.println(a.name + " " + a.phone + " " + a.email);
//        });
//        System.out.println();

        Stream<StreamCollectTest.NamePhone> namePhoneStream = namePhoneEmailList.stream().map((a) -> new StreamCollectTest.NamePhone(a.name, a.phone));

//        System.out.println("List of names and phone numbers: ");
//        namePhoneStream.forEach((a) -> {
//            System.out.println(a.name + " " + a.phone);
//        });
//        System.out.println();

        List<NamePhone> namePhoneList = namePhoneStream.collect(Collectors.toList());

        System.out.println("Names and Phone numbers in a List");
        for (NamePhone namePhone : namePhoneList) {
            System.out.println(namePhone.name + ":" + namePhone.phone);
        }

        namePhoneStream = namePhoneEmailList.stream().map((a) -> new StreamCollectTest.NamePhone(a.name, a.phone));

        Set<NamePhone> namePhoneSet = namePhoneStream.collect(Collectors.toSet());
        System.out.println("Names and Phone numbers in a Set");
        for (NamePhone namePhone : namePhoneSet) {
            System.out.println(namePhone.name + ":" + namePhone.phone);
        }
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