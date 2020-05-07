package com.learncamel.eip.aggregator;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.*;
/**
 * Created by Dilip on 6/1/17.
 */
public class AggregatorEIPRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:input")
                .log("Body :  ${body}  correlation id :  ${header.myId}")
                .aggregate(header("id"), new CustomAggregatorStrategy()).completionSize(3)
                .log("Sending out ${body}")
                .to("mock:output");
    }
}
