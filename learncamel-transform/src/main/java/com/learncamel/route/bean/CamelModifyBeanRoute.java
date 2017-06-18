package com.learncamel.route.bean;

import com.learncamel.processor.CamelBean;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 6/14/17.
 */
public class CamelModifyBeanRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:beanInput")
                .bean(new CamelBean(), "map")
              //.bean(new CamelBean())
                .log("Received Message is ${body} and Headers are ${headers}")
                //.to("file:data/output?fileName=output.txt");
                .to("mock:output");

    }
}
