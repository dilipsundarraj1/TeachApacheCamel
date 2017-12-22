package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

/**
 * Created by z001qgd on 12/22/17.
 */
public class AggregatorWithGroupedExchangeRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new AggregatorWithGroupedExchangeRoute();
    }

    @Test
    public void groupExchangeTest() throws InterruptedException {

        MockEndpoint mockEndpoint = getMockEndpoint("mock:grpoutput");



        template.sendBodyAndHeader("direct:grpAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:grpAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:grpAggregator", "3", "aggregatorId", 1);

        assertMockEndpointsSatisfied();

        Exchange exchangeList = mockEndpoint.getExchanges().get(0);

        List<Exchange> exchangeList1 = (List<Exchange>) exchangeList.getProperty(Exchange.GROUPED_EXCHANGE);
        for (Exchange exchange : exchangeList1 ){
            System.out.println("Exchange Body is : " + exchange.getIn().getBody());
        }



    }
}
