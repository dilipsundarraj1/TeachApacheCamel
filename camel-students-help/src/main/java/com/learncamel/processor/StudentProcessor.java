package com.learncamel.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learncamel.model.Student;
import org.apache.camel.Exchange;

/**
 * Created by Dilip on 12/14/17.
 */
public class StudentProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {



        Student student = (Student) exchange.getIn().getBody();

        System.out.println("Student  Obj is  : " + student);


        if(student.getName().equals("Sudheer")){
            //you can write your logic here
        }else if (student.getName().equals("sandu")){
            //you can write your logic here
        }


    }
}
