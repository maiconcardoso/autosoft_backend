package br.com.autosoft.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import br.com.autosoft.controller.CustomerController;

@WebMvcTest
public class CustomerControllerTest {
    
    @Mock
    private CustomerController customerController;
    
    
    @Test
    public void mustReturnRegisteredCustomer_whenSuccesfull(){
        
    }
}
