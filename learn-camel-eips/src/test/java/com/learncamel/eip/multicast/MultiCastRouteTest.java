package com.learncamel.eip.multicast;

import com.learncamel.eip.contentbasesrouter.ContentBasedRouterRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 7/22/17.
 */
public class MultiCastRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new MultiCastRoute();
    }

    @Test
    public void multicastRouteTest() throws InterruptedException {

        Thread.sleep(5000);
        File file = new File("output1");

        assertTrue(file.isDirectory());

        File file2 = new File("output1");
        assertTrue(file2.isDirectory());
    }

}
