package com.learncamel.routes.jdbc;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Dilip on 5/27/17.
 */
public class DBPostgresRouteTest extends CamelTestSupport {

    @Override
    public CamelContext createCamelContext() {

        String url = "jdbc:postgresql://localhost:5432/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource",dataSource);

        CamelContext context = new DefaultCamelContext(registry);
        // plug in a seda component, as we don't really need an embedded broker
        return context;
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new DBPostgresRoute();
    }

    @Test
    public void insertData(){

        String input = "first db input";
       ArrayList responseList =  template.requestBody("direct:dbInput", input, ArrayList.class);
       System.out.println("responseList : " + responseList.size());
       assertNotEquals(0,responseList.size());

    }

    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("postgres");
        ds.setUrl(connectURI);
        return ds;
    }


}
