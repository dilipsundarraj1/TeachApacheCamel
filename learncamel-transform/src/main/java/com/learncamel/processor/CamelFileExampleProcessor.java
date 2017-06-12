package com.learncamel.processor;

import org.apache.camel.Exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by z001qgd on 6/12/17.
 */
public class CamelFileExampleProcessor implements org.apache.camel.Processor {

    String newValue="";
    public void process(Exchange exchange) throws Exception {

        File file = new File((String) exchange.getIn().getHeaders().get("CamelFilePath"));
        String readLine=null;

        if(file!=null){

            FileReader file1 = new FileReader(file);
            BufferedReader reader = new BufferedReader(file1);

            while((readLine =reader.readLine()) !=null){
                System.out.println("Read line is : " + readLine);

                String oldValue = readLine;

                System.out.println("Old Value is : " + oldValue);

                newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");

                System.out.println("New Value is :  " + newValue);

                exchange.getIn().setBody(newValue);
            }

        }

    }
}
