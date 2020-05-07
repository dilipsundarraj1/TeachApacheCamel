package com.learncamel.bean;

/**
 * Created by Dilip on 6/14/17.
 */
public class CamelBean {

    public String map(String input){

        String newBody = input.replace(",", "*");

        return  newBody;

    }

    public String map2(String input){

        String newBody = input.replace(",", "~");

        return  newBody;

    }
}
