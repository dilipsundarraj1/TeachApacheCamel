package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Dilip on 12/24/17.
 */
public class FixedPositionUnMarshalRouteDateTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new FixedPositionUnMarshalRouteDate();
    }

    @Test
    public void unMarshalFixedPositionDate() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);
        assertEquals("dilip",employeeList.get(0).getName().trim());
        LocalDate expeectedDate = LocalDate.of(2017,01,12);
        assertEquals(expeectedDate.getYear(),employeeList.get(0).getJoinDate().getYear());
    }

}
