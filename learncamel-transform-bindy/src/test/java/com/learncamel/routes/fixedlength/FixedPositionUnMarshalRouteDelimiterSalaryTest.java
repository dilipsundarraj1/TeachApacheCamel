package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Dilip on 12/24/17.
 */
public class FixedPositionUnMarshalRouteDelimiterSalaryTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new FixedPositionUnMarshalRouteDelimiterSalary();
    }

    @Test
    public void salaryTest() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);
        assertEquals("dilip",employeeList.get(0).getName());

        BigDecimal expectedSalary = new BigDecimal("100000.00");
        assertEquals(expectedSalary, employeeList.get(0).getSalary());

    }
}
