package com.learncamel.route.xml2java;

import com.learncamel.domain.PurChaseOrders;
import com.learncamel.domain.PurchaseOrder;
import com.learncamel.route.xmlxstream.MarshalUsingXStream;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Xml2JavaTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new Xml2Java();
    }

    @Test
    public void unMarshalPurchaseOrder() throws  IOException {

        String inputXml = new String(Files.readAllBytes(Paths.get("src/test/resources/purchaseorder-single.xml")));

        PurChaseOrders purchaseOrders  = (PurChaseOrders) template.requestBody("direct:purchaseOrderInput", inputXml);

        System.out.println("output : "+ purchaseOrders);
        assertEquals(1, purchaseOrders.getPurchaseOrders().size());

    }

    @Test
    public void unMarshalPurchaseOrders() throws InterruptedException, IOException {

        String inputXml = new String(Files.readAllBytes(Paths.get("src/test/resources/purchaseorder-multiple.xml")));

        PurChaseOrders purchaseOrders  = (PurChaseOrders) template.requestBody("direct:purchaseOrderInput", inputXml);

        System.out.println("output : "+ purchaseOrders);

        assertEquals(2, purchaseOrders.getPurchaseOrders().size());

    }
}
