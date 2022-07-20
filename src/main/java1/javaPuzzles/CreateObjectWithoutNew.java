package main.java1.javaPuzzles;

/**
 * @author jitendra.kumar01
 * 02/02/20
 */
public class CreateObjectWithoutNew {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException {
        //Using Class.forName() and Class.newInstance()
        Class ref = Class.forName("Demo");
        Demo obj = (Demo) ref.newInstance();

        //using clone method
        Demo obj1 = new Demo();
        Demo obj2 = (Demo) obj.clone();

    }
}

class Demo implements Cloneable {

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //utilize clone Object method
    }
}
