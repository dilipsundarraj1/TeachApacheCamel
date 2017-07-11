package com.learncamel.routes.kafka2jdbc;

import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 7/11/17.
 */
public class Kafka2JdbcRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest")
                .log("${body}")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from messages?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true");
                //.to("direct:output");

    }
}
