package com.learncamel.routes.excetion;

import org.apache.camel.Exchange;

/**
 * Created by Dilip on 7/19/17.
 */
public class ExceptionProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Acutal Exceptipn Message "  + e.getMessage());
        System.out.println("Acutal Exceptipn Class "  + e.getClass());

        String failedEndoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndoint);


        exchange.getIn().setBody("Exception happened in the route.");
    }
}
