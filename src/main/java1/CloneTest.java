package main.java1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jitendra.kumar01
 * 17/12/19
 */


public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp = new Employee();

        emp.setId(1);
        emp.setName("Pankaj");
        Map<String, String> props = new HashMap<>();
        props.put("salary", "10000");
        props.put("city", "Bangalore");
        emp.setProps(props);

        Employee clonedEmp = (Employee) emp.clone();

        // Check whether the emp and clonedEmp attributes are same or different
        System.out.println("emp and clonedEmp == test: " + (emp == clonedEmp));

        System.out.println("emp and clonedEmp HashMap == test: " + (emp.getProps() == clonedEmp.getProps()));

        // Let's see the effect of using default cloning

        // change emp props
        emp.getProps().put("title", "CEO");
        emp.getProps().put("city", "New York");
        System.out.println("clonedEmp props:" + clonedEmp.getProps());

        // change emp name
        emp.setName("new");
        System.out.println("clonedEmp name:" + clonedEmp.getName());


        Employee emp2 = new Employee(emp);
        System.out.println("clonedEmp name:" + clonedEmp.getName());




        EmployeeWrap empWrap = new EmployeeWrap();

        empWrap.setId(1);
        empWrap.setName("Pankaj");
        empWrap.setTitle("CEO");

        Map<String, String> props1 = new HashMap<>();
        props1.put("salary", "10000");
        props1.put("city", "Bangalore");
        empWrap.setProps(props1);

        EmployeeWrap clonedEmpWrap = (EmployeeWrap) empWrap.clone();

        empWrap.getProps().put("1", "1");

        System.out.println("empWrap mutable property value = "+empWrap.getProps());

        System.out.println("clonedEmpWrap mutable property value = "+clonedEmpWrap.getProps());

    }


}


class Employee implements Cloneable{

    private int id;

    private String name;

    private Map<String, String> props;

    public Employee() {
    }

    //copy constructor
    public Employee(Employee emp) {

        this.setId(emp.getId());
        this.setName(emp.getName());

        Map<String, String> hm = new HashMap<>();
        String key;
        Iterator<String> it = emp.getProps().keySet().iterator();
        // Deep Copy of field by field
        while (it.hasNext()) {
            key = it.next();
            hm.put(key, emp.getProps().get(key));
        }
        this.setProps(hm);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProps() {
        return props;
    }

    public void setProps(Map<String, String> p) {
        this.props = p;
    }

    /*//shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
*/
    //deep copy
    public Object clone() throws CloneNotSupportedException {

        Object obj = super.clone(); //utilize clone Object method

        Employee emp = (Employee) obj;

        // deep cloning for immutable fields
        emp.setProps(null);
        Map<String, String> hm = new HashMap<>();
        String key;
        Iterator<String> it = this.props.keySet().iterator();
        // Deep Copy of field by field
        while (it.hasNext()) {
            key = it.next();
            hm.put(key, this.props.get(key));
        }
        emp.setProps(hm);

        return emp;
    }

}
class EmployeeWrap extends Employee implements Cloneable {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
}