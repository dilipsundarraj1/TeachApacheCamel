package com.learncamel.route;

import com.learncamel.route.process.CamelModifyDirectProcessorRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 6/11/17.
 */
public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    /**
     * This test case will check the content using requestBody() method.
     */
    @Test
    public void processorTest() {

        String expected = "123:dilip:12JAN2017";

        String output = (String) template.requestBody("process:processorInput","123,dilip,12JAN2017" );

        System.out.println("output : " + output);
            assertEquals(expected , output);

    }

    /**
     * This test case will check the content using Mock() method.
     */
    @Test
    public void processorTestUsingMock() throws InterruptedException {

        String expected = "123:dilip:12JAN2017";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);


        String output = (String) template.requestBody("process:processorInput","123,dilip,12JAN2017" );

        System.out.println("output : " + output);
        assertMockEndpointsSatisfied();

    }

}
