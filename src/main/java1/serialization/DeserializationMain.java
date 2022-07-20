package main.java1.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
public class DeserializationMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("employee.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            Employee employee = (Employee) objectInputStream.readObject();
            System.out.printf(employee.toString());
        }
    }
}
