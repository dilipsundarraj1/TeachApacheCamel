package com.learncamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by z001qgd on 6/11/17.
 */
public class CamelModifyProcessorRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    /**
     * This test case will check the number of files in the directory.
     */
    @Test
    public void processorTest() {

        template.sendBody("direct:processorInput","123,dilip,12JAN2017" );
            File file = new File("data/output");

            assertTrue(file.isDirectory());

            assertEquals(1,file.listFiles().length);

    }

}
