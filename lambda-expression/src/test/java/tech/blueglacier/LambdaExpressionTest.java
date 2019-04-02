package tech.blueglacier;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.function.UnaryOperator;

/**
 * Refer : https://www.tutorialspoint.com/java8/index.htm
 * Refer : https://www.tutorialspoint.com/java9/index.htm
 */
public class LambdaExpressionTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testLambdaExpression() {
        // Lambda expression sample
//        () -> 98.6;
//        () -> Math.random() * 100;
//        (n) -> 1.0 / n;
//        (n) -> (n % 2) == 0;
//        n -> (n % 2) == 0;
    }

    @Test
    public void testLambdaExpressionImplementation() {
        MyValue myValue;
        myValue = () -> 98.6;
        MyValue myValue2 = () -> 98.6;
        System.out.println("Evaluated lambda expressions : " + myValue.getValue()
                + "," + myValue2.getValue());

        MyParamValue myParamValue = (double n) -> 1.0 / n;

        System.out.println("Reciprocal of 4 is : " + myParamValue.getValue(4.0));
    }

    @Test
    public void testNumericTest() {
        NumericTest isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2)) {
            System.out.println("2 is factor of 10");
        }

        NumericTest lessThan = (n, m) -> (n < m);

        if (lessThan.test(2, 10)) {
            System.out.println("2 is less than 10");
        }
    }

    @Test
    public void testBlockLambda() {
        NumericFunc smallestFactor = (n) -> {
            int result = 1;

            n = n < 0 ? -n : n;

            for (int i = 2; i <= n / i; i++) {
                if ((n % i) == 0) {
                    result = i;
                    break;
                }
            }
            return result;
        };

        System.out.println("Smallest factor of 12 is : " + smallestFactor.func(12));
        System.out.println("Smallest factor of 11 is : " + smallestFactor.func(11));
    }

    @Test
    public void testGenericLambda() {
        SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2)) {
            System.out.println("2 is factor of 10");
        }

        SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;

        String str = "Generic functional interface";
        System.out.println("Testing str : " + str);

        if (isIn.test(str, "face")) {
            System.out.println("'face' is found");
        }
    }

    @Test
    public void testLambdaArgumentDemo() {

        String inStr = "Lambda Expressions Expand Java";
        String outStr;

        System.out.println("Here is input string: " + inStr);

        StringFunc reverse = (str) -> {
            String result = StringUtils.EMPTY;
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        outStr = changeString(reverse, inStr);

        System.out.println("The string reversed: " + outStr);

        //Lambda expression is embedded directly in the call to changeString()
        outStr = changeString((str) -> str.replace(' ', '-'), inStr);

        System.out.println("The string with spaces replaced : " + outStr);

        //Block Lambda expression is embedded directly in the call to changeString()
        outStr = changeString((str) -> {
            String result = StringUtils.EMPTY;
            char ch;
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch)) {
                    result += Character.toLowerCase(ch);
                } else {
                    result += Character.toUpperCase(ch);
                }
            }
            return result;
        }, inStr);

        System.out.println("The string in reversed case: " + outStr);

    }

    static String changeString(StringFunc stringFunc, String s) {
        return stringFunc.func(s);
    }
}
