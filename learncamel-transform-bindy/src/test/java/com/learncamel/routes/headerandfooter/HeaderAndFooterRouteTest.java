package com.learncamel.routes.headerandfooter;

import com.learncamel.routes.fixedlength.FixedPositionUnMarshalRouteDate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class HeaderAndFooterRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new HeaderAndFooterRoute();
    }

    @Test
    public void splittingFiles() throws InterruptedException {
        Thread.sleep(5000);

        File file = new File("data/headerandfooter/output");
        assertTrue(file.isDirectory());
    }

}
