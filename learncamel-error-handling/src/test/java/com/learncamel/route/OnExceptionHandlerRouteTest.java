package com.learncamel.route;

import com.learncamel.exception.ApplicationException;
import com.learncamel.route.defaulterrorhandler.DefaultErrorHandlerRoute;
import com.learncamel.route.onexception.OnExceptionHandlerRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Dilip on 7/3/17.
 */
public class OnExceptionHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck_nohandled(){

        String request=null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);

    }

    @Test
    public void exceptionCheck_handled_in_processor(){

        String request=null;
        String expected ="Exception happened in the route.";
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);
        assertEquals(expected, response);
    }

    @Test
    public void exceptionCheck_continue(){

        String request=null;
        String expected =null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);
        assertEquals(expected, response);
    }


}
