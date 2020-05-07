package com.learncamel.processor;

import org.apache.camel.Exchange;

/**
 * Created by Dilip on 1/2/18.
 */
public class ClassX implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("X");
    }
}
