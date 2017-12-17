package com.learncamel.route.process;

import com.learncamel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 6/10/17.
 */
public class CamelModifyDirectProcessorRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("process:processorInput")
                .process(new CamelDirectExampleProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                //.to("file:data/output?fileName=output.txt");
                .to("mock:output");
    }
}
