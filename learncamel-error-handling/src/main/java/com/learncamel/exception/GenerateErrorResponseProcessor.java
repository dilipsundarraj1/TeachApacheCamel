package com.learncamel.exception;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Dilip on 7/3/17.
 */
public class GenerateErrorResponseProcessor  implements Processor {

    public void process(Exchange exchange) throws Exception {

        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Acutal Exceptipn Message "  + e.getMessage());
        System.out.println("Acutal Exceptipn Class "  + e.getClass());

        String failedEndoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndoint);


        exchange.getIn().setBody("Exception happened in the route.");
    }
}
