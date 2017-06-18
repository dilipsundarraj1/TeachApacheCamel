package com.learncamel.route.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 6/17/17.
 */
public class XML2JSONRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new XML2JSONRoute();
    }

    @Test
    public void marshalEmployeeJSON2XML(){

        String expected = "{\"id\":\"123 \",\"name\":\"ABC\",\"type\":\"senior\"}";
        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123 </id><name>ABC</name><type>senior</type></Employee>\r\n";

        final String response = template.requestBody("direct:marshalEmployeexml2json", request, String.class);
        System.out.println("response is : " + response);

        assertEquals(expected, response);

    }

    @Test
    public void unMarshalEmployeeJSON2XML(){

        final String request = "{\"name\":\"ABC\",\"id\":\"123 \",\"type\":\"senior\"}";

        final String response = template.requestBody("direct:unMarshalEmployeejson2xml", request, String.class);
        System.out.println("response is : " + response);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123 </id><name>ABC</name><type>senior</type></Employee>\r\n";
        assertEquals(expected, response);

    }
}
