package main.java1.java8;

/**
 * @author jitendra.kumar01
 * 27/01/20
 */

//allow only single abstract method
@FunctionalInterface
public interface MyFirstFunctionalInterface {
    public void firstWork();

    @Override
    public String toString();                //Overridden from Object class

    @Override
    public boolean equals(Object obj);        //Overridden from Object class

    default void doSomeMoreWork1(){
        //Method body
    }

    default void doSomeMoreWork2(){
        //Method body
    }

}