package com.learncamel.route.direct;

import com.learncamel.processor.CamelExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 6/10/17.
 */
public class CamelModifyDirectProcessorRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("direct:processorInput")
                .process(new CamelExampleProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                //.to("file:data/output?fileName=output.txt");
                .to("mock:output");
    }
}
