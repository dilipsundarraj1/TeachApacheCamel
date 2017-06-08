package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by z001qgd on 6/7/17.
 */
public class CopyFilesMultiRoute {

    public static void main(String[] args) {
        CamelContext context= new DefaultCamelContext();

        try{
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            //.to("log:?level=INFO&showBody=true&showHeaders=true")
                            .log("Received Message is ${body} and Headers are ${headers}")
                            .to("file:data/output")
                            .to("file:data/anothetdestination");


                }
            });

            context.start();
            Thread.sleep(5000);
            context.stop();

        }catch(Exception e){
            System.out.println("Inside Exception : " + e);
        }

    }
}
