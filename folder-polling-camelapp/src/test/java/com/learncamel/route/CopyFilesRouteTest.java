package com.learncamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 1/9/18.
 */
public class CopyFilesRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new CopyFilesRoute();
    }

    @Test
    public void testFolderLoop() throws InterruptedException {

        Thread.sleep(3000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
    }
}
