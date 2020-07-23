package org.apde.learning.springhw.model;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A model object that encapsulates a greeting.
 * 
 * It also maintains a counter of the number of greetings issued since
 * starting the application.
 * 
 * @author ameyjoshi
 *
 */
public class Greeting {
    private static final AtomicLong counter = new AtomicLong();
    private long count;
    private String greetingStr;

    public Greeting(String name) {
        count = counter.getAndIncrement();
        this.greetingStr = String.format("Hello, %s", name);
    }

    public long getCount() {
        return count;
    }

    public String getGreetingStr() {
        return greetingStr;
    }
}
