package main.design_pattern.creational.builder;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String primaryPhNo;

    private String middleName;
    private String secondaryEmail;
    private String secondaryPhNo;


    public Customer(CustomerBuilder customerBuilder) {
        this.firstName = customerBuilder.firstName;
        this.lastName = customerBuilder.lastName;
        this.email = customerBuilder.email;
        this.primaryPhNo = customerBuilder.primaryPhNo;
        this.middleName = customerBuilder.middleName;
        this.secondaryEmail = customerBuilder.secondaryEmail;
        this.secondaryPhNo = customerBuilder.secondaryPhNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPrimaryPhNo() {
        return primaryPhNo;
    }

    public static class CustomerBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String primaryPhNo;
        private String middleName;
        private String secondaryEmail;
        private String secondaryPhNo;

        public CustomerBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public CustomerBuilder setSecondaryEmail(String secondaryEmail) {
            this.secondaryEmail = secondaryEmail;
            return this;
        }

        public CustomerBuilder setSecondaryPhNo(String secondaryPhNo) {
            this.secondaryPhNo = secondaryPhNo;
            return this;
        }

        public CustomerBuilder(String firstName, String lastName, String email, String primaryPhNo) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.primaryPhNo = primaryPhNo;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
