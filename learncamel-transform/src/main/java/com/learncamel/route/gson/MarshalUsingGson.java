package com.learncamel.route.gson;

import com.learncamel.domain.Student;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

/**
 * Created by z001qgd on 12/20/17.
 */
public class MarshalUsingGson extends RouteBuilder {
    public void configure() throws Exception {
        GsonDataFormat format = new GsonDataFormat(Student.class);

        from("direct:marshalGSON")
                .log("Received Message is ${body} and Headers are ${headers}")
                .marshal(format)
                .log("Received Message is ${body} and Headers are ${headers}");//
    }
}
