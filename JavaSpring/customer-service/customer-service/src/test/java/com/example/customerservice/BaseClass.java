package com.example.customerservice;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(classes = CustomerServiceApplication.class)
@RunWith(SpringRunner.class)
public class BaseClass {
    @Autowired
    public CustomerRestController customerRestController;

    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void before() {
        Mockito.when(this.customerRepository.findAll()).thenReturn(Arrays.asList(new Customer(1L, "Jane"), new Customer( 2L, "Bob")));
        RestAssuredMockMvc.standaloneSetup(this.customerRestController);







    }
}
