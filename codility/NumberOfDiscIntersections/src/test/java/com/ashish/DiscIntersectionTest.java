package com.ashish;

import com.ashish.SimpleService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Ashish Sharma
 */
public class DiscIntersectionTest {

    @Test
    public void getIntersectionTest() {
        int[] a = new int[]{1, 5, 2, 1, 4, 0};
        System.out.println(intersections(a));
    }

    private static int intersections(int[] a) {
        int result = 0;
        int[] dps = new int[a.length];
        int[] dpe = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            dps[Math.max(0, i - a[i])]++;
            dpe[Math.min(a.length - 1, i + a[i])]++;
        }

        int t = 0;
        for (int i = 0; i < a.length; i++) {
            if (dps[i] > 0) {
                result += t * dps[i];
                result += dps[i] * (dps[i] - 1) / 2;
                t += dps[i];
            }
            t -= dpe[i];
        }

        return result;
    }


    @Test
    public void testRetrial() throws IOException {
        Integer a = null;
        print(a);
    }


    public void print(Integer a) throws IOException {
        System.out.println("print");
//        throw new IOException();


//        Callable<Boolean> callable = new Callable() {
//            public Boolean call() throws Exception {
//                System.out.println("ashish");
//                throw  new IOException();
////                return true;
//            }
//        };
//
//        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
//                .retryIfResult(Predicates.<Boolean>isNull())
//                .retryIfExceptionOfType(IOException.class)
//                .retryIfRuntimeException()
//                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
//                .build();
//        try {
//            retryer.call(callable);
//        } catch (RetryException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void aspectTest() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
//        simpleService.printNameId();
        System.out.println("---------------");
        try {
//            simpleService.checkName();
            simpleService.myName();
        } catch (Exception e) {
            System.out.println("SimpleService checkName() : Exception thrown..");
            System.out.println(ExceptionUtils.getFullStackTrace(e));
        }
//        System.out.println("---------------");
//        simpleService.sayHello("Javacodegeeks");
//        System.out.println("---------------");
        context.close();
    }
}

