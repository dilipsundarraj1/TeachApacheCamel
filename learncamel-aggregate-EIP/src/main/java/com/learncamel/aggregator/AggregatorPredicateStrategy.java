package com.learncamel.aggregator;

import org.apache.camel.Exchange;

/**
 * Created by z001qgd on 12/22/17.
 */
public class AggregatorPredicateStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

            return newExchange;

    }
}
