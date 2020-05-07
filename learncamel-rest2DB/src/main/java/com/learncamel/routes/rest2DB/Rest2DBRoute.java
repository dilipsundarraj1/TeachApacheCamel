package com.learncamel.routes.rest2DB;

import com.learncamel.routes.excetion.ExceptionProcessor;
import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

/**
 * Created by Dilip on 7/16/17.
 */
public class Rest2DBRoute extends RouteBuilder {


    public void configure() throws Exception {

        onException(PSQLException.class, Exception.class).handled(true).log("Exception While inserting messages.").process(new ExceptionProcessor());

        from("timer:learnTimer?period=10s")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("https://restcountries.eu/rest/v2/alpha/us"))
                .to("https://restcountries.eu/rest/v2/alpha/us").convertBodyTo(String.class)
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from country_capital?dataSource=myDataSource");

    }
}
