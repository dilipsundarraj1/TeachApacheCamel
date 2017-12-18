package com.learncamel.route.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by z001qgd on 6/17/17.
 */
public class UnMarshalUsingXStream extends RouteBuilder {

    public void configure() throws Exception {

        Map<String, String> reference = new HashMap<String, String>();
        reference.put("employee", Employee.class.getName());

        XStreamDataFormat xstreamDataFormat = new XStreamDataFormat();
        xstreamDataFormat.setAliases(reference);
        xstreamDataFormat.setPermissions(Employee.class.getName()); //Need permission on this class otherwise
        // it will through the com.thoughtworks.xstream.security.ForbiddenClassException: com.learncamel.transformXML.xstream.Employee


        from("direct:xmlinput")
                .unmarshal(xstreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
