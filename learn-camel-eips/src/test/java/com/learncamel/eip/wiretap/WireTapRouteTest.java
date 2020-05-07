package com.learncamel.eip.wiretap;

import com.learncamel.eip.multicast.MultiCastRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 7/22/17.
 */
public class WireTapRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new WireTapRoute();
    }

    @Test
    public void wireTapRoute() throws InterruptedException {

        Thread.sleep(5000);
        File file = new File("all");

        assertTrue(file.isDirectory());

        File fileDebug = new File("debug");

        assertTrue(fileDebug.isDirectory());
    }
}
