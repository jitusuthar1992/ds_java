/*
package main.java1.java8;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static List<Employee> createEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee("John", 21);
        Employee e2 = new Employee("Martin", 19);
        Employee e3 = new Employee("Mary", 31);
        Employee e4 = new Employee("Stephan", 18);
        Employee e5 = new Employee("Gary", 26);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        return employeeList;
    }


    public static void main(String[] args) {
        Stream<Character> charStream = Stream.of('a', 'b', 'b');


        charStream.forEach(System.out::println);
        //System.out.println(charStream.filter(x->x =='a').count());


        List<Employee> employees = new ArrayList();
        Address address = new Address();
        address.type = "Home";
        Address address1 = new Address();
        address1.type = "Office";

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

        Employee employee = new Employee();
        employee.addreses = addressList;
        employee.name = "Vikas";
        employee.salary = 10000;

        Employee employee1 = new Employee();
        employee1.addreses = addressList;
        employee1.name = "Vipul";
        employee1.salary = 15000;

        Employee employee2 = new Employee();
        employee2.addreses = addressList;
        employee2.name = "Summit";
        employee2.salary = 30000;

        Employee employee3 = new Employee();
        employee3.addreses = addressList;
        employee3.name = "Jitendra";
        employee3.salary = 10000;


        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        */
/*addressList = employees.stream().flatMap(e->e.addreses.stream()).collect(Collectors.toList());

        addressList = addressList.stream().filter(a->a.type.equals("Home")).collect(Collectors.toList());

        addressList.forEach(System.out::println);
        *//*



       */
/* List<Address> addresseses =  employees.stream().flatMap(e->e.addreses.stream()).collect(Collectors.toList());

        addresseses.stream().filter(a->a.type.equals("Home Address")).collect(Collectors.toList());*//*


        employees = employees.stream().sorted((o1, o2) -> {
            int diff = o2.salary - o1.salary;
            if (diff == 0) {
                return o1.name.compareTo(o2.name);
            }
            return diff;
        }).collect(Collectors.toList());

        employees.forEach(System.out::println);


        System.out.println("MaximumUsingStreamMain");
        List<Employee> employeeList = createEmployeeList();
        List<String> employeeFilteredList = employeeList.stream().filter(e -> e.age > 20).map(Employee::getName).collect(Collectors.toList());
        employeeFilteredList.forEach((name) -> System.out.println(name));

        System.out.println("the list of employees, count number of employees with age 25");
        employeeList = createEmployeeList();

        System.out.println("the list of employees, count number of employees with age 25" + employeeList.stream().filter(e -> e.age > 25).count());

        Optional<Employee> optionalEmployee = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase("Mary")).findAny();

        if (optionalEmployee.isPresent()) {
            System.out.println(optionalEmployee.get());
        }


        OptionalInt max = employeeList.stream().mapToInt(Employee::getAge).max();
        if (max.isPresent())
            System.out.println("Maximum age of Employee: " + max.getAsInt());


        System.out.println("Sorted List");

        List<String> sortedList = employeeList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).map(Employee::getName).collect(Collectors.toList());
        sortedList.forEach(System.out::println);


        Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
        map.forEach((name, employeeListTemp) -> System.out.println("Name: " + name + " ==>" + employeeListTemp));
    }


}

class Employee {

    public String name;
    public int age;
    public int salary;
    public List<Address> addreses;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Address> getAddreses() {
        return addreses;
    }

    public void setAddreses(List<Address> addreses) {
        this.addreses = addreses;
    }


    public Employee(String name, int salary, List<Address> addreses) {
        this.name = name;
        this.salary = salary;
        this.addreses = addreses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", addreses=" + addreses +
                '}';
    }
}

class Address {
    public String type;

    @Override
    public String toString() {
        return "Address{" +
                "type='" + type + '\'' +
                '}';
    }
}
*/
