package main.java1.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
class Employee implements Serializable {
    public int age;
    public String name;
    public int salary;
    String lastName;
    Address address;

    public Employee(int age, String name, int salary, String lastName) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.lastName = lastName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" + "age=" + age + ", name='" + name + '\'' + ", salary=" + salary + ", lastName='" + lastName + '\'' + ", address=" + address + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        if (age != employee.age)
            return false;
        if (salary != employee.salary)
            return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null)
            return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null)
            return false;
        return address != null ? address.equals(employee.address) : employee.address == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    private void writeObject(ObjectOutputStream os) throws IOException, ClassNotFoundException {
        try {
            os.defaultWriteObject();
            os.writeInt(address.getHomeNo());
            os.writeObject(address.getStreet());
            os.writeObject(address.getCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        try {
            is.defaultReadObject();
            int homeNo = is.readInt();
            String street = (String) is.readObject();
            String city = (String) is.readObject();
            address = new Address(homeNo, street, city);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
