package com.learncamel.gson;

import com.learncamel.domain.Student;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

/**
 * Created by z001qgd on 12/19/17.
 */
public class UnMarshalUsingGson extends RouteBuilder {
    public void configure() throws Exception {
        GsonDataFormat format = new GsonDataFormat(Student.class);
        from("direct:gson").unmarshal(format);//

    }
}
