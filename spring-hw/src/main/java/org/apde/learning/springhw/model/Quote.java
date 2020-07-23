package org.apde.learning.springhw.model;

/**
 * A model object to encapsulate the results of spring.io's REST service.
 * 
 * The REST service is available at {@link SpringHwController#URL}.
 *  
 * @author ameyjoshi
 *
 */
public class Quote {
    private String type;
    private Value value;

    public Quote(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Quote[type=%s, value=%s", type, value.toString());
    }
}
