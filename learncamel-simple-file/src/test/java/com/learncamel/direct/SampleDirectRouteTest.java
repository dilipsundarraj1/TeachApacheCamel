package com.learncamel.direct;

import com.learncamel.file.CopyFilesRoute;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by z001qgd on 6/8/17.
 */
public class SampleDirectRouteTest extends CamelTestSupport {
    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }


    @Test
    public void sampleRouteTest() throws InterruptedException {

        template.sendBody("direct:sampleInput","Hello" );

        Thread.sleep(5000);
        
        File file = new File("sampleOutput");

        assertTrue(file.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");

        System.out.println("Received body is :" + exchange.getIn().getBody());
        System.out.println("File Name is :" + exchange.getIn().getHeader("CamelFileName"));

        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));

        

    }




}
