package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;

/**
 * Created by Dilip on 12/26/17.
 */
@Message(keyValuePairSeparator = "=", pairSeparator = " ")
public class Student {

    @KeyValuePairField(tag = 1)
    private String id;
    @KeyValuePairField(tag = 2)
    private String name;
    @KeyValuePairField(tag = 3)
    private String grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
