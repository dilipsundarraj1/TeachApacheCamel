package com.learncamel.route;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 1/2/18.
 */
public class XYRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new XYRoute();
    }


    @Test
    public void xyTest() throws InterruptedException {

        String input = "AB";
        template.sendBody("direct:A", input);
        Thread.sleep(2000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());

    }
}
