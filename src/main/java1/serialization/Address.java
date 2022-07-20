package main.java1.serialization;

import java.io.Serializable;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
public class Address implements Serializable {
    int homeNo;
    String street;
    String city;

    public Address(int homeNo, String street, String city) {
        super();
        this.homeNo = homeNo;
        this.street = street;
        this.city = city;
    }

    public int getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(int homeNo) {
        this.homeNo = homeNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "homeNo=" + homeNo + ", street='" + street + '\'' + ", city='" + city + '\'' + '}';
    }
}
