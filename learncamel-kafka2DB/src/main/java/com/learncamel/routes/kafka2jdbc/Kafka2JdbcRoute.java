package com.learncamel.routes.kafka2jdbc;

import com.learncamel.routes.exception.ExceptionProcessor;
import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.kafka.common.KafkaException;
import org.postgresql.util.PSQLException;

/**
 * Created by Dilip on 7/11/17.
 */
public class Kafka2JdbcRoute extends RouteBuilder {

    public void configure() throws Exception {

        onException(PSQLException.class, Exception.class).handled(true).log("Exception While inserting messages.").process(new ExceptionProcessor());

        from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest")
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from messages?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true");
                //.to("direct:output");

    }
}
