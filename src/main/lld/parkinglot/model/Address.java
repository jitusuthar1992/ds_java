package main.lld.parkinglot.model;

public class Address {
    private String street;
    private String block;
    private String city;
    private String state;
    private String country;

    public Address(String street, String block, String city, String state, String country) {
        this.street = street;
        this.block = block;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address(String city, String state, String country) {
        this.street = street;
        this.block = block;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
