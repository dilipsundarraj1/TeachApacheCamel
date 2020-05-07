package com.learncamel.route;

import com.learncamel.route.defaulterrorhandler.DefaultErrorHandlerRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by Dilip on 7/1/17.
 */
public class DefaultErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck() throws InterruptedException {

        String expectedOutput = "123*dilip*12JAN17";
        String input=null;

        MockEndpoint mock = getMockEndpoint("mock:errorqueue");
        mock.expectedBodiesReceived(expectedOutput);

        template.sendBody("direct:exception",input);

        assertMockEndpointsSatisfied();


    }
}
