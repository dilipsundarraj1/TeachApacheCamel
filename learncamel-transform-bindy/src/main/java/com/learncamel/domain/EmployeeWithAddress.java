package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;

/**
 * Created by Dilip on 12/6/17.
 */
@CsvRecord( separator = ",",skipFirstLine=true)
public class EmployeeWithAddress {

    //"10","Dilip","Sundarraj"
    @DataField(pos = 1,position = 10)
    private String id;

    @DataField(pos = 2,position = 11)
    private String firstName;

    @DataField(pos = 3,position = 12)
    private String lastName;

    @Link
    private  Address address;

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmployeeWithAddress{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
