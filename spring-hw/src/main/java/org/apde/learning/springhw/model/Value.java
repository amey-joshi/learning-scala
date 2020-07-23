package org.apde.learning.springhw.model;

/**
 * A model class to encapsulate one of the fields in the response of
 * spring.io's REST service.
 * 
 * The REST service is available at {@link SpringHwController#URL}.
 * 
 * @author ameyjoshi
 *
 */
public class Value {
    private Long id;
    private String quote;

    public Value(Long id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return String.format("Value[id=%d, quote=%s", id, quote);
    }
}
