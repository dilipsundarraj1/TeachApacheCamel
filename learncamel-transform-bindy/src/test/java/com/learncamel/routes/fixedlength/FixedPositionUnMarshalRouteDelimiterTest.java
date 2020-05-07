package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dilip on 12/24/17.
 */
public class FixedPositionUnMarshalRouteDelimiterTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new FixedPositionUnMarshalRouteDelimiter();
    }

    @Test
    public void unMarshalFixedPositionDelimiter() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);
        assertEquals("dilip",employeeList.get(0).getName().trim());
        //assertEquals(30,employeeList.get(0).getAge());

    }
}
