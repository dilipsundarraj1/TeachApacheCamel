package com.learncamel.eip.aggregator;

import org.apache.camel.Exchange;

/**
 * Created by Dilip on 6/2/17.
 */
public class CustomAggregatorStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if(oldExchange==null)
            return newExchange;


        String oldBody = oldExchange.getIn().getBody(String.class);

        String newBody = newExchange.getIn().getBody(String.class);

        String body = oldBody + newBody;

        oldExchange.getIn().setBody(body);

        return oldExchange;
    }
}
