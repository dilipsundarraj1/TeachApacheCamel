package com.learncamel.routes.jdbc;

import org.apache.camel.Exchange;

/**
 * Created by Dilip on 5/26/17.
 */
public class InsertProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        String input = (String) exchange.getIn().getBody();
        System.out.println("Input to be persisted : " + input);

        String insertQuery = "INSERT INTO messages value ( '1','" + input+"')";
        System.out.println("Insert Query is : " + insertQuery);
        exchange.getIn().setBody(insertQuery);

    }
}
