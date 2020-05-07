package com.learncamel.routes.fixedlength;

import com.learncamel.domain.Employee;
import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;

/**
 * Created by Dilip on 12/24/17.
 */
public class FixedPositionMarshalRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return new FixedPositionMarshalRoute();
    }

    @Test
    public void positionMarshalTest() throws InterruptedException {

        EmployeeWithFixedLength employeeWithFixedLength = new EmployeeWithFixedLength();
        employeeWithFixedLength.setId(1);
        employeeWithFixedLength.setName("Adam");
        employeeWithFixedLength.setAge(30);
        employeeWithFixedLength.setJoinDate(LocalDate.now());
        employeeWithFixedLength.setRole("Engineer");

        template.sendBody("direct:input",employeeWithFixedLength);

        Thread.sleep(5000);

        File file = new File("data/fixedposition/output");
        assertTrue(file.isDirectory());


    }
}
