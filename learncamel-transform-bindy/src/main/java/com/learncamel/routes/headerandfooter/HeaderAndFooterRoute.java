package com.learncamel.routes.headerandfooter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class HeaderAndFooterRoute extends RouteBuilder  {


    private final String HEADER = "(MH7000)";
    private final String FOOTER = "(RRRR)";

    public void configure() throws Exception {

        from("file:data/headerandfooter/input?fileName=samplefile&noop=true")
                .split((body().tokenize("(MH7000)")))
                .streaming()
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String body = (String) exchange.getIn().getBody();
                        if(((String) exchange.getIn().getBody()).contains("(") || ((String) exchange.getIn().getBody()).contains(")")){
                            body =  body.replace("(","");
                            body =  body.replace(")","");
                            if(!body.equals(""))
                                body = HEADER.concat(body);
                            body =  body.replace("RRRR",FOOTER);

                        };
                        exchange.getIn().setBody(body);
                    }
                })
               .log("Tokenized output is : ${body}")
                .choice()
                .when(body().isNotEqualTo(""))
                .to("file:data/headerandfooter/output?fileName=${file:name}-${date:now:yyyyMMddHHmmssSSS}");
    }
}
