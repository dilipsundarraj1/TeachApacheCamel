package com.learncamel.routes.keyvaluepair;

import com.learncamel.domain.Student;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.kvp.BindyKeyValuePairDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/26/17.
 */
public class KeyValueMarshalRoute extends RouteBuilder {
    public void configure() throws Exception {

        DataFormat bindyKeyValuePairDataFormat = new BindyKeyValuePairDataFormat(Student.class);

        from("direct:keyValueRoute")
                .marshal(bindyKeyValuePairDataFormat)
                .log("Marshaled Message is : ${body}")
                .to("file:data/keyValue/output?fileName=key-value-file-output.txt");
    }
}
