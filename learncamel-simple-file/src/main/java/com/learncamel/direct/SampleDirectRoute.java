package com.learncamel.direct;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 6/8/17.
 */
public class SampleDirectRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
        .to("file:sampleOutput?fileName=output.txt");
    }
}
