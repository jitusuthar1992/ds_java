package main.designpattern1.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonClass implements Serializable,Cloneable {
    private static volatile SingletonClass  instance;

    private SingletonClass(){
        throw new IllegalStateException("Object exists already");
    }

    public static SingletonClass getInstance(){
        if(null == instance){
            synchronized (SingletonClass.class){
                if(null == instance){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    // to suppress creating new object during de-serialization
    protected SingletonClass readResolve() throws ObjectStreamException {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // directly throw Clone Not Supported Exception
        throw new CloneNotSupportedException();
    }
}
