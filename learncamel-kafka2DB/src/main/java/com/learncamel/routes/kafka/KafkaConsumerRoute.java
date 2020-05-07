package com.learncamel.routes.kafka;

import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 7/11/17.
 */
public class KafkaConsumerRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest")
                .log("${body}")
                .to("direct:readFromKafka");

        //With SSL
        /*from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest&securityProtocol=SSL&sslKeystoreLocation=${sslKeystorePath}&sslKeystorePassword=${sslKeystorePassword}&sslTruststoreLocation=${sslTruststorePath}&sslTruststorePassword=${sslTruststorePassword}")
         .log("${body}")
                .to("direct:readFromKafka");
*/
    }
}
