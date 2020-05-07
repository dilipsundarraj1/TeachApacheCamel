package com.learncamel.routes.fixedlength;

import com.learncamel.domain.Employee;
import com.learncamel.domain.EmployeeWithFixedLength;
import com.learncamel.routes.csv.CSVMarshalRoute;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dilip on 12/23/17.
 */
public class FixedPositionUnMarshalRouteTest extends CamelTestSupport{
    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new FixedPositionUnMarshalRoute();
    }

    @Test
    public void unMarshalFixedPositionTest() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);
        assertEquals("dilip",employeeList.get(0).getName().trim());
        //assertEquals(Local);


    }

    @Test
    public void unMarshalFixedPositionTest_ignoreTrailingChars() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);
        assertEquals("dilip",employeeList.get(0).getName());


    }


}
