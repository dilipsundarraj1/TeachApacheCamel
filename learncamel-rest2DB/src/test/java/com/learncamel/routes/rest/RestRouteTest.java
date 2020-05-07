package com.learncamel.routes.rest;

import com.learncamel.routes.rest.RestRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by Dilip on 7/13/17.
 */
public class RestRouteTest extends CamelTestSupport {


    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RestRoute();
    }

    @Test
    public void restCall(){

      String response =   template.requestBody("direct:restCall","USA",String.class);
        System.out.println("response : " + response);
        assertNotNull(response);
    }

}
