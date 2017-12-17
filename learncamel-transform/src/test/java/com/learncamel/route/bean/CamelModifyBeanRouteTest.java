package com.learncamel.route.bean;

import com.learncamel.route.transform.CamelModifyTransformRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by z001qgd on 6/14/17.
 */
public class CamelModifyBeanRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTest(){
        String expected = "123*dilip*12JAN2017";
        String output = (String) template.requestBody("process:beanInput","123,dilip,12JAN2017" );
        System.out.println("output : "+ output);

        assertEquals(expected,output);
    }
}
