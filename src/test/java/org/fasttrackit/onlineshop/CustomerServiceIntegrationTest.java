package org.fasttrackit.onlineshop;

import org.fasttrackit.onlineshop.domain.Customer;
import org.fasttrackit.onlineshop.service.CustomerService;
import org.fasttrackit.onlineshop.transfer.customer.SaveCustomerRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testCreateCustomor_WhenValidRequest_thenReturnCreatedCustomer(){
        SaveCustomerRequest request = new SaveCustomerRequest();
        request.setFirstName("CustomerFirstName");
        request.setLastName("CustomerLastName");
        Customer customer = customerService.createCustomer(request);

        assertThat(customer, notNullValue());
        assertThat(customer.getFirstName(),is(request.getFirstName()));
        assertThat(customer.getLastName(),is(request.getLastName()));
        assertThat(customer.getId(),notNullValue());
        assertThat(customer.getId(),greaterThan(0L));

    }
}
