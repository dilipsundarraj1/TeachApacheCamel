package com.learncamel.route;

import com.learncamel.route.process.CamelModifyFileProcessorRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by z001qgd on 6/12/17.
 */
public class CamelModifyFileProcessorRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        String expected="123:dilip:12JAN2017\n" +
                "456:adam:12JAN2017\n";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());

        assertEquals(1,file.listFiles().length);

        assertMockEndpointsSatisfied();

    }
}
