package main.java1.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
public class SerializationMain {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee(27, "Avinash", 30000, "Kumar");
        Address address = new Address(88, "MG road", "Pune");

        employee.setAddress(address);

        try (FileOutputStream fileOutputStream = new FileOutputStream("employee.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            objectOutputStream.writeObject(employee);
        }
    }
}
