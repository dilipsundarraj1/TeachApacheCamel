package com.learncamel.routes.keyvaluepair;

import com.learncamel.domain.Student;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.kvp.BindyKeyValuePairDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/26/17.
 */
public class KeyValueUnMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {

        DataFormat bindyKeyValuePairDataFormat = new BindyKeyValuePairDataFormat(Student.class);

        from("file:data/keyValue/input?fileName=key-value-file1.txt&noop=true")
                .unmarshal(bindyKeyValuePairDataFormat)
                .log("UnMarshaled message is ${body}")
                .to("direct:output");
    }
}
