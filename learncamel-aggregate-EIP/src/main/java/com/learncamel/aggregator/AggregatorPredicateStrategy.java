package com.learncamel.aggregator;

import org.apache.camel.Exchange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dilip on 12/22/17.
 */
public class AggregatorPredicateStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if(oldExchange==null){
            return newExchange;

        }else{
            String oldBody = (String) oldExchange.getIn().getBody();
            String newBody = (String) newExchange.getIn().getBody();

            newBody = oldBody.concat(":").concat(newBody);

            newExchange.getIn().setBody(newBody);


            return newExchange;
        }
    }
}
