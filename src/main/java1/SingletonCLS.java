package main.java1;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author jitendra.kumar01
 * 19/02/20
 */
public class SingletonCLS implements Serializable, Cloneable {
    // Eager-Instantiation: only-time INSTANCE created
    private volatile static SingletonCLS INSTANCE = new SingletonCLS();

    // private constructor
    private SingletonCLS() {
        // helps to suppress creating objects either
        // 1. by new operator/keyword or
        // 2. by reflection API and newInstance() method
    }

    // create static method to get same instance every time
    public static SingletonCLS getInstance() {
        return INSTANCE;
    }

    // to suppress creating new object during de-serialization
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // directly throw Clone Not Supported Exception
        throw new CloneNotSupportedException();
    }

    // other utility methods and details of this class
}
