package com.learncamel.processor;

import org.apache.camel.Exchange;

/**
 * Created by z001qgd on 6/10/17.
 */
public class CamelDirectExampleProcessor implements org.apache.camel.Processor {


    public void process(Exchange exchange) throws Exception {

        try{
            String oldValue = (String) exchange.getIn().getBody();

            System.out.println("Old Value is : " + oldValue);

            String newValue = oldValue.replace(",", ":");

            System.out.println("New Value is :  " + newValue);

            exchange.getIn().setBody(newValue);

        }catch (Exception e){
            System.out.println("Exception in processor is : " + e);
        }

    }
}
