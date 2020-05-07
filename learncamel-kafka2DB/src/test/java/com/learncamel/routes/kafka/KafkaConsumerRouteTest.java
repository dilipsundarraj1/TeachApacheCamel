package com.learncamel.routes.kafka;

import com.learncamel.routes.kafka.KafkaConsumerRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by Dilip on 7/11/17.
 */
public class KafkaConsumerRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new KafkaConsumerRoute();

    }

    @Test
    public void readMessageFromKafka(){

        String expected = "123";
        String response = consumer.receiveBody("direct:readFromKafka", String.class);
        System.out.println("The response is : " + response);
        assertEquals(expected,response);
    }


}
