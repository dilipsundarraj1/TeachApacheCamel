package com.learncamel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 6/11/17.
 */
public class SampleMockRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {

        String expected="Hello";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        /**
         * Producer Template.
         */
        template.sendBody("direct:sampleInput","Hello" );

        assertMockEndpointsSatisfied();


    }

}
