package java1;

import java.io.Serializable;

public class Singleton implements Serializable {
    public static final Singleton INSTANCE = new Singleton();
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private Singleton() {
    }
    protected Object readResolve() {
        return INSTANCE;
    }
}
