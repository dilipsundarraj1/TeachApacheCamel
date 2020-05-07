package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/18/17.
 */
public class CSVUnMarshalWithLinkRoute extends RouteBuilder{

    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("file:data/csv/input?fileName=fileWithAddress.txt&noop=true")
                    .unmarshal(bindy)
                .log("Marshaled Input : ${body} and headers are ${headers}")
        .to("direct:output");

    }
}
