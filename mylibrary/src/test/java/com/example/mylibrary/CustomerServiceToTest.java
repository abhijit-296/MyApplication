package com.example.mylibrary;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceToTest {


    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddCustomer_returnsNewCustomer() {
        when(daoMock.save(any(Customer.class))).thenReturn(new Customer());
        Customer customer = new Customer();
        assertThat(service.addCustomer(customer), is(notNullValue()));
    }
    //Using Answer to set an id to the customer which is passed in as a parameter to the mock method.
    @Test
    public void testAddCustomer_returnsNewCustomerWithId() {
        when(daoMock.save(any(Customer.class))).thenAnswer(new Answer<Customer>() {
            @Override
            public Customer answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                if (arguments != null && arguments.length > 0 && arguments[0] != null){
                    Customer customer = (Customer) arguments[0];
                    customer.setCustomerId(1);
                    return customer;
                }
                return null;
            }
        });
        Customer customer = new Customer();
        assertThat(service.addCustomer(customer), is(notNullValue()));
    }
    //Throwing an exception from the mocked method
    @Test(expected = RuntimeException.class)
    public void testAddCustomer_throwsException() {
        when(daoMock.save(any(Customer.class))).thenThrow(RuntimeException.class);
        Customer customer = new Customer();
        service.addCustomer(customer);//
    }

}
