package com.learncamel.route.xmlxstream;

import com.learncamel.domain.Employee;
import com.learncamel.processor.CustomProcessorXStream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by z001qgd on 6/17/17.
 */
public class MarshalUsingXStream extends RouteBuilder {



    public void configure() throws Exception {

        from("direct:csvinput")
                .process(new CustomProcessorXStream())
               // .marshal().xstream()
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateStreamDef() {

        XStreamDataFormat xstreamDefinition = new XStreamDataFormat();

        Map<String, String> aliases = new HashMap<String, String>();

        aliases.put("employee", Employee.class.getName());

        xstreamDefinition.setAliases(aliases);

        return xstreamDefinition;
    }
}
