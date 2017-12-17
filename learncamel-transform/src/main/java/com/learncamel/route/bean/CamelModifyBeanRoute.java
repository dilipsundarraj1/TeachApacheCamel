package com.learncamel.route.bean;

import com.learncamel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 6/14/17.
 */
public class CamelModifyBeanRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("process:beanInput")
              .bean(new CamelBean())
                //.bean(new CamelBean(), "map")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");

    }
}
