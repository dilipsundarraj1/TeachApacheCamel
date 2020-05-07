package com.learncamel.routes.jdbc;

import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

/**
 * Created by Dilip on 5/26/17.
 */
public class DBPostgresRoute extends RouteBuilder {

    public void configure() throws Exception {

        onException(PSQLException.class).handled(true).log("Exception While inserting messages.");

        from("direct:dbInput")
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from country_capital?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true");

    }


}
