package com.learncamel.processor;

/**
 * Created by z001qgd on 6/14/17.
 */
public class CamelBean {

    public String map(String input){

        String newBody = input.replace(",", "*");

        return  newBody;

    }
}
