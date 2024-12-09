package it.unibo.javafx.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Counter {
    private final IntegerProperty value;

    public Counter() {
        this.value = new SimpleIntegerProperty(0);
    }

    public void increment() {
        value.set(value.get() + 1);
    }

    public void decrement() {
        value.set(value.get() - 1);
    }

    public IntegerProperty counterProperty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
