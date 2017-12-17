package com.learncamel.route.process;

import com.learncamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 6/12/17.
 */
public class CamelModifyFileProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .process(new CamelFileExampleProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
