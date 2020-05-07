package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Created by Dilip on 12/6/17.
 */
//@CsvRecord( separator = ",",skipFirstLine=true )
//@CsvRecord( separator = ";",skipFirstLine=true )
//@CsvRecord( separator = "\\|",skipFirstLine=true )
@CsvRecord( separator = "\\*",skipFirstLine=true ,generateHeaderColumns = true)
//@CsvRecord( separator = ",",skipFirstLine=true ,generateHeaderColumns = true)
public class Employee {

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

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';

    }

    //"10","Dilip","Sundarraj"
    @DataField(pos = 1)
    private String id;

    @DataField(pos = 2)
    private String firstName;

    @DataField(pos = 3)
    private String lastName;
}
