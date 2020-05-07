package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 12/17/17.
 */
public class CSVMarshalRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new CSVMarshalRoute();
    }

    @Test
    public void marhsalRouteTest(){

        Employee employee = new Employee();
        employee.setId("123");
        employee.setFirstName("Dilip");
        employee.setLastName("Sundar");


        template.sendBody("direct:objInput", employee);

        File file = new File("data/csv/output");
        assertTrue(file.isDirectory());
    }
}
