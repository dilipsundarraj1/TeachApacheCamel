package com.learncamel.routes.jms;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;

import static org.apache.activemq.camel.component.ActiveMQComponent.activeMQComponent;

/**
 * Created by Dilip on 5/26/17.
 */
public class JmsReadRoute extends RouteBuilder {

    public void configure() throws Exception {


        from("activemq:queue:testQueue")
                .to("log:?level=INFO&showBody=true")
        .to("direct:readQueue");

    }
}
