package main.truebalance;

/**
 * @author jitendra.kumar01
 * 07/02/20
 */
public class OverrideFinalMethod extends Parent {

    /*public final void show(){
        System.out.println("call Show");
    }*/
}


class Parent {
    public final void show(){
        System.out.println("call Show");
    }
}
