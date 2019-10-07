package main.java1;



 class ParentClass {

    public static void classMethod(){
        System.out.println("classMethod in Parent class");
    }
    public void instanceMethod(){
        System.out.println("instanceMethod in Parent class");
    }
}
 class ChildClass extends ParentClass {
    public static void classMethod(){
        System.out.println("classMethod in Child class");
    }
    public void instanceMethod(){
        System.out.println("instanceMethod in Child class");
    }
}
public class MethodHiding {
    public static void main(String[] args) {

        ParentClass p=new ChildClass();
        p.classMethod(); // Calling with reference. (Method hiding)
        p.instanceMethod(); // Calling with object. (Method overriding)

        ChildClass c=new ChildClass();
        c.classMethod(); // Calling with reference.
        c.instanceMethod(); // Calling with object.

        ParentClass p1=new ParentClass();
        p1.classMethod();  // Calling with reference.
        p1.instanceMethod(); // Calling with object.
    }
}