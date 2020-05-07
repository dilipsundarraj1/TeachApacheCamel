package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import com.learncamel.routes.csv.CSVUnMarshalRoute;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dilip on 12/6/17.
 */
public class CSVUnMarshalRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnMarshalRoute();
    }

    @Test
    public void cvsUnmarshalRouteTest() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(5000);

        List<Employee> employeeList = (List<Employee>) exchange.getIn().getBody();
        for(Employee employee1 : employeeList ){
            System.out.println("Employee in test case : " + employee1);
        }

        assertEquals("01", employeeList.get(0).getId());
        assertEquals("Kevin", employeeList.get(1).getFirstName());
    }

}
