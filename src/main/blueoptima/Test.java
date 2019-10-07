package main.blueoptima;


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        /*A1 a1 = new B1();
        System.out.println();
        new B1();*/


        /*HashMap*/
        Map<Employee,Integer> map = new HashMap<>();
        Employee emp1 = new Employee(23,"Test1",100000,"L1");
        System.out.println(emp1.hashCode());
        Employee emp2 = new Employee(23,"Test2",100000,"L2");
        System.out.println(emp2.hashCode());
        //System.out.println(emp1.equals(emp1));


       /* Employee emp3 = new Employee(23,"Test1",100000);

        Employee emp4 = new Employee(24,"Test1",100000);*/

       map.put(emp1,emp1.age);
        map.put(emp2,emp2.age);
        /*map.put(emp3,emp3.age);

        map.put(emp4,emp4.age);*/
        System.out.println(map);

        System.out.println(map.get(emp1));
    }
}

class A1{
    public A1() {
        System.out.println("Cons A1");
    }
    static {
        System.out.println("Static a");
    }

    {
        System.out.println("init a");
    }
}

class B1 extends A1{
    public B1() {
        System.out.println("Cons B1");
    }
    static {
        System.out.println("Static B1");
    }

    {
        System.out.println("init B1");
    }
}

class Employee{
    public int age;
    public String name ;
    public int salary ;
    String lastName;

    public Employee(int age, String name, int salary,String lastName) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(this.hashCode());
    }
}
