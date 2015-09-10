package com.realdolmen.course.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by JDOAX80 on 10/09/2015.
 */
@Embeddable
public class Address {
    String street1;
    String street2;
    String city;
    String zipCode;
    String country;

    /*
     * Used by JPA
     */
    protected Address(){}

    public Address(String street1, String street2, String city, String zipCode, String country) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
