package com.learncamel.route;

import com.learncamel.model.Student;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by Dilip on 12/14/17.
 */
public class StudentRouteTest extends CamelTestSupport {


    @Override
    protected RouteBuilder createRouteBuilder(){
        return  new StudentRoute();
    }

    @Test
    public  void  testStudentRoute1() throws InterruptedException {


        String jsonInput = "{ \"id\":\"1\" ,\"name\":\"sudheer\",\"phonenumber\" :\"123456789\"}";

        Student student =  (Student) template.requestBody("direct:rest", jsonInput);

        assertEquals(1,student.getId());



    }

}
