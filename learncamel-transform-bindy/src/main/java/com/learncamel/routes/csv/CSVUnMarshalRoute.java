package com.learncamel.routes.csv;


import com.learncamel.domain.Employee;
import com.learncamel.processor.EmployeeProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * Created by Dilip on 12/6/17.
 */
public class CSVUnMarshalRoute extends RouteBuilder {


    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(Employee.class);
        //from("file:data/csv/input?fileName=file1.txt&noop=true")
        /*from("file:data/csv/input?fileName=file2.txt&noop=true")*/
        /*from("file:data/csv/input?fileName=file3.txt&noop=true")*/
        from("file:data/csv/input?fileName=file4.txt&noop=true")
                .unmarshal(bindy)
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .process(new EmployeeProcessor())
                .to("direct:output");

    }
}
