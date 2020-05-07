package com.learncamel.routes.keyvaluepair;

import com.learncamel.domain.Student;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 12/26/17.
 */
public class KeyValueMarshalRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return new KeyValueMarshalRoute();
    }

    @Test
    public void marshalKeyValueTest() throws InterruptedException {

        Student student = new Student();
        student.setGrade("12");
        student.setId("1");
        student.setName("Dilip");

        template.sendBody("direct:keyValueRoute",student);

        Thread.sleep(3000);
        File file = new File("data/keyValue/output/key-value-file-output.txt");
        assertTrue(file.isFile());
    }
}
