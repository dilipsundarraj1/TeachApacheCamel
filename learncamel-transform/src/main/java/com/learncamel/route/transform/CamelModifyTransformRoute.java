package com.learncamel.route.transform;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 6/13/17.
 */
public class CamelModifyTransformRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("process:transformInput")
                .transform(body().regexReplaceAll(",","*"))
                .to("mock:output");
    }
}
