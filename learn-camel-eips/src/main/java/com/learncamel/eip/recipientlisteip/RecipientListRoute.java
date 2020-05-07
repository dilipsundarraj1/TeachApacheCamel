package com.learncamel.eip.recipientlisteip;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 7/22/17.
 */
public class RecipientListRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:xmlinput?noop=true")
                .setHeader("type", xpath("/employee/@type"))
                .process(new RecipientEIPProcessor())
                .recipientList(header("type"));

    }
}
