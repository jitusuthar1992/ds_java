package main.java1.java8;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        Stream<Character> charStream = Stream.of('a','b','b');


        charStream.forEach(System.out::println);
        //System.out.println(charStream.filter(x->x =='a').count());



        List<Employee> employees = new ArrayList();
        Address address = new Address();
        address.type="Home";
        Address address1 = new Address();
        address1.type="Office";

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

        Employee employee = new Employee();
        employee.addreses = addressList;
        employee.name="Vikas";
        employee.salary = 10000;

        Employee employee1 = new Employee();
        employee1.addreses = addressList;
        employee1.name="Vipul";
        employee1.salary = 15000;

        Employee employee2 = new Employee();
        employee2.addreses = addressList;
        employee2.name="Summit";
        employee2.salary = 30000;

        Employee employee3 = new Employee();
        employee3.addreses = addressList;
        employee3.name="Jitendra";
        employee3.salary = 10000;



        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        /*addressList = employees.stream().flatMap(e->e.addreses.stream()).collect(Collectors.toList());

        addressList = addressList.stream().filter(a->a.type.equals("Home")).collect(Collectors.toList());

        addressList.forEach(System.out::println);
        */


       /* List<Address> addresseses =  employees.stream().flatMap(e->e.addreses.stream()).collect(Collectors.toList());

        addresseses.stream().filter(a->a.type.equals("Home Address")).collect(Collectors.toList());*/

       employees = employees.stream().sorted((o1, o2) -> {
           int diff = o2.salary - o1.salary;
           if(diff == 0){
               return o1.name.compareTo(o2.name);
           }
           return diff;
        }).collect(Collectors.toList());

       employees.forEach(System.out::println);
    }



}

class Employee{

    public String name;
    public int salary;
    public List<Address> addreses ;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", addreses=" + addreses +
                '}';
    }
}

class Address{
    public String type;

    @Override
    public String toString() {
        return "Address{" +
                "type='" + type + '\'' +
                '}';
    }
}
