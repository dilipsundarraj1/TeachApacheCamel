package com.learncamel.eip.contentbasesrouter;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 7/19/17.
 */
public class ContentBasedRouterRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:input?noop=true") //noop - Dont perform any operation after moving the content.
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                    .when(header("CamelFileNameConsumed").endsWith(".html"))
                        .to("file:html")
                    .when(header("CamelFileNameConsumed").endsWith(".txt"))
                        .to("file:text")
                    .when(header("CamelFileNameConsumed").endsWith(".json"))
                        .to("file:json")
                    .otherwise()
                        .to("file:other")
                        //.to("file:other").stop()
                    .end()
        .to("file:all");

    }
}
