package com.learncamel.routes;

import com.learncamel.aggregator.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 12/21/17.
 */
public class AggregatorWithCompletionTimeoutRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Recieved Message is ${body} and key ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy()).completionSize(2).completionTimeout(3000)
                .log("Aggregated Message is ${body}")
                .to("mock:output");

    }
}
