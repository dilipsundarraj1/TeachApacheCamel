package com.learncamel.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by z001qgd on 6/17/17.
 */
public class Employee {

    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    private String id;
    private String joinDate;
}
