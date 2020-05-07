package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by Dilip on 12/18/17.
 */
public class CSVUnMarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new CSVUnMarshalWithLinkRoute();
    }

    @Test
    public void csvWithLinkRouteTest(){
        Exchange exchange = consumer.receive("direct:output");


        EmployeeWithAddress employeeWithAddress  = (EmployeeWithAddress) exchange.getIn().getBody();
        System.out.println(employeeWithAddress);

        assertEquals("USA", employeeWithAddress.getAddress().getCountry());
    }
}
