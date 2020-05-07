package com.learncamel.routes.rest;

import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 7/11/17.
 */
public class RestRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:restCall")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("https://restcountries.eu/rest/v2/alpha/${body}"))
                .to("https://restcountries.eu/rest/v2/alpha/${body}")
                .to("log:?level=INFO&showBody=true");


    }
}
