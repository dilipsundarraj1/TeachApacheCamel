package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/19/17.
 */
public class CSVMarshalWithLinkRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("direct:objInput")
                .marshal(bindy)
                .log("Marshaled Input : ${body} and headers are ${headers}")
                .to("file:data/csv/output?fileName=outputWithAddress.txt");

    }
}
