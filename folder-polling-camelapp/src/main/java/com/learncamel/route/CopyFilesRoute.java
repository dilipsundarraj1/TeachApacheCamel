package com.learncamel.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 1/9/18.
 */
public class CopyFilesRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("timer:CSVReader?period=10s" )
                .log("Timer Triggered")
                .pollEnrich("file:data/input?noop=true")
                .to("log:?Level=INFO&showBody=true&showHeaders=true")
                .to("file:data/output");

    }
}
