package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/17/17.
 */
public class CSVMarshalRoute extends RouteBuilder {


    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(Employee.class);

        from("direct:objInput")
                .marshal(bindy)
                .log("Marshaled Input : ${body} and headers are ${headers}")
                .to("file:data/csv/output?fileName=output.txt");
    }
}
