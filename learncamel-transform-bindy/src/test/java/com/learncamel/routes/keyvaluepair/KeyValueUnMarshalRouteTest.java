package com.learncamel.routes.keyvaluepair;

import com.learncamel.domain.Student;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dilip on 12/26/17.
 */
public class KeyValueUnMarshalRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return new KeyValueUnMarshalRoute();
    }

    @Test
    public void unMarshalKeyValuePair() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<Student> students = (List<Student>) exchange.getIn().getBody();

        System.out.println(students);

        assertEquals("dilip", students.get(0).getName());
        assertEquals("kevin", students.get(1).getName());

    }
}
