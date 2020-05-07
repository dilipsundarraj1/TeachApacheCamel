package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/23/17.
 */
public class FixedPositionUnMarshalRoute extends RouteBuilder {
    public void configure() throws Exception {

        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("file:data/fixedposition/input?fileName=FixedPositionFile.txt&noop=true")
                .unmarshal(bindy)
                .to("direct:output");
    }
}
