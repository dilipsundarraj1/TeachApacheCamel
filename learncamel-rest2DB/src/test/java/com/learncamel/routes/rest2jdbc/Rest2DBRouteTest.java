package com.learncamel.routes.rest2jdbc;

import com.learncamel.routes.jdbc.DBPostgresRoute;
import com.learncamel.routes.rest2DB.Rest2DBRoute;
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
 * Created by Dilip on 7/16/17.
 */
public class Rest2DBRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new Rest2DBRoute();
    }

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

    @Test
    public void rest2dbroute(){

        ArrayList responseList =  consumer.receiveBody("direct:dbInput", ArrayList.class);
        System.out.println("responseList : " + responseList.size());

        assertNotEquals(0, responseList.size());

    }

    @Test
    public void rest2dbroute_exception(){

        ArrayList responseList =  consumer.receiveBody("timer:learnTimer", ArrayList.class);

        assertNull(responseList);

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
