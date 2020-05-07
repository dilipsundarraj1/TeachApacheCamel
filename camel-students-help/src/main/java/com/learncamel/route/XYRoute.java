package com.learncamel.route;

import com.learncamel.processor.ClassX;
import com.learncamel.processor.ClassY;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 1/2/18.
 */
public class XYRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:A")
                .log("Message is ${body}")
                .to("file:data/output?fileName=output.txt")
                .log("Message is ${body}")
                .process(new ClassX())
                .log("Message is ${body}")
                .process(new ClassY())
                .log("Message is ${body}");


    }
}
