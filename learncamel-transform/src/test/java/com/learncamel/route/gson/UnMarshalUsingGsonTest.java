package com.learncamel.route.gson;

import com.learncamel.domain.Student;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 12/19/17.
 */
public class UnMarshalUsingGsonTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingGson();
    }

    @Test
    public void UnmarshalGsonTest(){
        String jsonInput = "{ \"id\":\"1\" ,\"name\":\"sudheer\",\"phonenumber\" :\"123456789\"}";

        Student student =  (Student) template.requestBody("direct:unMarshalGSON", jsonInput);

        assertEquals(1,student.getId());

    }


}
