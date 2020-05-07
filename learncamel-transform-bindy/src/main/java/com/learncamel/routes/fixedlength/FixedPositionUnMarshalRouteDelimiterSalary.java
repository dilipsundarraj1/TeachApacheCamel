package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/24/17.
 */
public class FixedPositionUnMarshalRouteDelimiterSalary extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("file:data/fixedposition/input?fileName=FixedPositionFile-Delimiter-salary.txt&noop=true")
                .unmarshal(bindy)
                .log("Unmarshaled Body is : ${body}")
                .to("direct:output");
    }
}
