package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 6/27/2015.
 */
import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

//@Documented
//@Target ({ElementType.FIELD, ElementType.METHOD })
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Retry {

    /**
     * How many times to retry.
     * @checkstyle MagicNumber (2 lines)
     */
    int attempts() default 3;

    /**
     * Delay between attempts, in time units.
     * @checkstyle MagicNumber (2 lines)
     */
    long delay() default 50;

    /**
     * Time units.
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

    /**
     * When to retry (in case of what exception types).
     */
    Class<? extends Throwable>[] types() default { Throwable.class };

    /**
     * Exception types to ignore.
     */
    Class<? extends Throwable>[] ignore() default { };

    /**
     * Shall it be fully verbose (show full exception trace) or just
     * exception message?
     */
    boolean verbose() default true;

    /**
     * Shall the time between retries by randomized.
     */
    boolean randomize() default true;

}