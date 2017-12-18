package com.learncamel.route.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 6/17/17.
 */
public class MarshalUsingXStreamTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXStream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {

        String expected = "<?xml version='1.0' encoding='UTF-8'?><com.learncamel.domain.Employee><name>dilip</name><id>123</id><joinDate>01APR2017</joinDate></com.learncamel.domain.Employee>";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:csvinput", "dilip,123,01APR2017");

        assertMockEndpointsSatisfied();

    }

    @Test
    public void marshalXstreamCustomXmLlTest() throws InterruptedException {

        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><name>dilip</name><id>123</id><joinDate>01APR2017</joinDate></employee>";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:csvinput", "dilip,123,01APR2017");

        assertMockEndpointsSatisfied();

    }
}
