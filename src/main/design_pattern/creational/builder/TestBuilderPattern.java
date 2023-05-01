package main.design_pattern.creational.builder;

public class TestBuilderPattern {
    public static void main(String[] args) {
        Customer customer = new Customer.CustomerBuilder("Ajit","Suthar",
                "ajit@gmail.com","12112212").setMiddleName("kumar").build();
    }
}
