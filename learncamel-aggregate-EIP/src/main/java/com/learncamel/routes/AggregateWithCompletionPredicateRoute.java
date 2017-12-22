package com.learncamel.routes;

import com.learncamel.aggregator.AggregatorPredicateStrategy;
import com.learncamel.domain.Order;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

/**
 * Created by z001qgd on 12/21/17.
 */
public class AggregateWithCompletionPredicateRoute extends RouteBuilder{
    public void configure() throws Exception {

        GsonDataFormat dataFormat = new GsonDataFormat(Order.class);
        from("direct:completionPredicate")
                .log("Recieved Message is ${body} and key ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorPredicateStrategy())
                .log(" Message after Aggregation Strategy is ${body} and key ${header.aggregatorId}")
                .completionPredicate(body().contains("order-confirm")).eagerCheckCompletion()
                .log("Final Message is : ${body} ")
                .to("mock:output");
    }
}
