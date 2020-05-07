package com.learncamel.eip.wiretap;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 7/22/17.
 */
public class WireTapRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:input?noop=true")
                .wireTap("file:debug")
                .to("file:all");
    }
}
