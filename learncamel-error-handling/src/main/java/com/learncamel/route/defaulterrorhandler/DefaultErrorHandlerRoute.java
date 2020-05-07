package com.learncamel.route.defaulterrorhandler;

import com.learncamel.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 7/1/17.
 */
public class DefaultErrorHandlerRoute extends RouteBuilder {


    public void configure() throws Exception {

        //Error Logging
        //errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retryAttemptedLogLevel(LoggingLevel.WARN));
        //Error Logging exponetial back off
        //errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));


        from("direct:exception")
                .bean(new DataModifier(), "map")
                .to("log:?level=INFO&showBody=true")
                .to("mock:errorqueue");

    }
}
