package com.learncamel.routes;

import com.learncamel.routes.AggregateWithCompletionPredicateRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dilip on 12/22/17.
 */
public class AggregateWithCompletionPredicateRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new AggregateWithCompletionPredicateRoute();

    }

    @Test
    public void predicateTest() throws InterruptedException {

        String orderCreate = "12345,samsung-phone,order-created";
        String orderConfirm = "12345,samsung-phone,order-confirm";

        MockEndpoint mock = getMockEndpoint("mock:output");

        mock.expectedBodiesReceived(orderCreate.concat(":").concat(orderConfirm));



        template.sendBodyAndHeader("direct:completionPredicate", orderCreate, "aggregatorId", 12345);
        template.sendBodyAndHeader("direct:completionPredicate", orderConfirm, "aggregatorId", 12345);

        assertMockEndpointsSatisfied();

    }

}
