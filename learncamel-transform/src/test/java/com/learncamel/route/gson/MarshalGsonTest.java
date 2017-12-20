package com.learncamel.route.gson;

import com.learncamel.domain.Student;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 12/20/17.
 */
public class MarshalGsonTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGson(){
        Student student=new Student();
        student.setId(1);
        student.setName("Dilip");
        student.setPhonenumber("2183984979");
        String expected = "{\"id\":1,\"name\":\"Dilip\",\"phonenumber\":\"2183984979\"}";

        String studentJson = (String) template.requestBody("direct:marshalGSON", student,String.class);
        System.out.println("studentJson : " + studentJson);
        assertEquals(expected,studentJson);
    }
}
