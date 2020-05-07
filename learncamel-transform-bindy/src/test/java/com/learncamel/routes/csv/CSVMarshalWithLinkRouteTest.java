package com.learncamel.routes.csv;

import com.learncamel.domain.Address;
import com.learncamel.domain.Employee;
import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by Dilip on 12/19/17.
 */
public class CSVMarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return  new CSVMarshalWithLinkRoute();
    }

    @Test
    public void marshalWithLinkTest() throws InterruptedException {

        EmployeeWithAddress employee = new EmployeeWithAddress();
        employee.setId("123");
        employee.setFirstName("Dilip");
        employee.setLastName("Sundar");
        Address address = new Address();
        address.setAddressLine("12345 ABC lane");
        address.setCity("APple Valley");
        address.setCountry("USA");
        address.setState("MN");
        address.setZip("12345");
        employee.setAddress(address);



        template.sendBody("direct:objInput", employee);

        Thread.sleep(3000);
        File file = new File("data/csv/output/outputWithAddress.txt");
        assertTrue(file.exists());
    }



}
