package com.learncamel.route.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 6/17/17.
 */
public class UnMarshalUsingXStreamTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingXStream();
    }

    @Test
    public void unMarshalTest() throws InterruptedException {

        Employee employee = new Employee();
        employee.setName("Daniel");
        employee.setId("123");
        employee.setJoinDate("01APR2017");
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(employee.toString());
        template.sendBody("direct:xmlinput", " <employee><name>Daniel</name><id>123</id><joinDate>01APR2017</joinDate></employee>");

        assertMockEndpointsSatisfied();

    }

}
