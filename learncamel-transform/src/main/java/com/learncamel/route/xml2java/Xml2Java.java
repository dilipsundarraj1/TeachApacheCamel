package com.learncamel.route.xml2java;

import com.learncamel.domain.PurChaseOrders;
import com.learncamel.domain.PurchaseOrder;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Xml2Java extends RouteBuilder {



    public void configure() throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(PurChaseOrders.class);
        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);

        from("direct:purchaseOrderInput")
                .unmarshal(jaxbDataFormat);

    }
}
