package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

/**
 * Created by z001qgd on 12/22/17.
 */
public class AggregatorWithGroupedExchangeRoute extends RouteBuilder{

    public void configure() throws Exception {

        from("direct:grpAggregator")
                .log("Received Message is ${body} and key ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy()).completionSize(3)
                .log("Aggregated Message is ${body} and key ${header.aggregatorId}")
                .to("mock:grpoutput");


    }
}
