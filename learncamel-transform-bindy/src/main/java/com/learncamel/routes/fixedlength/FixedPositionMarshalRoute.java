package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/24/17.
 */
public class FixedPositionMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("direct:input")
                .marshal(bindy)
                .log("Marshaled output is : ${body}")
                .to("file:data/fixedposition/output?fileName=FixedPositionFile.txt&noop=true");
    }
}
