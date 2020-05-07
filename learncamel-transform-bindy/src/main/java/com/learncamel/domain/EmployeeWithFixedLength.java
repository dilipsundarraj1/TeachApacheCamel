package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Dilip on 12/23/17.
 */
//@FixedLengthRecord(length = 21,ignoreTrailingChars = true)ignoreTrailingChars-> This is used to ignore the characters after the last mapped field.
//@FixedLengthRecord(length = 30)
@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

    @DataField(pos = 1, length = 3)
    private int id;
    @DataField(pos = 2, length = 10,trim = true,align = "L")
    private String name;
    @DataField(pos = 3, length = 8)
    private String role;
    @DataField(pos = 4, length = 9, pattern = "ddMMMyyyy")
    private LocalDate joinDate;
    @DataField(pos = 5, delimiter = "^")
    private int age;
    @DataField(pos = 6, length =6 ,precision = 2)
    private BigDecimal salary;


    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", joinDate=" + joinDate +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}


