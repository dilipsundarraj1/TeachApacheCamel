package com.learncamel.route;

import com.learncamel.model.Student;
import com.learncamel.processor.StudentProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

/**
 * Created by z001qgd on 12/14/17.
 */
public class StudentRoute extends RouteBuilder {


    public void configure() throws Exception {


        GsonDataFormat format = new GsonDataFormat(Student.class);

       /* from("direct:rest").
                process(new StudentProcessor())
                .to("mock:output");*/
        from("direct:rest").unmarshal(format).process(new StudentProcessor());


    }
}
