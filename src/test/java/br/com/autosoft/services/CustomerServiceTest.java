package br.com.autosoft.services;

import static org.mockito.Mockito.clearInvocations;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.autosoft.entities.Customer;
import br.com.autosoft.service.CustomerService;

@DataJpaTest
public class CustomerServiceTest {
    
    @Mock
    private CustomerService service;
    
    private static final Integer idCustomer1 = 1;
    private static final Integer idCustomer2 = 2;
    Customer customer1 = new Customer(idCustomer1, "Maicon Cardoso", "44991682996", "07545268980", "maiconscardoso@hotmail.com", "Paranavaí", "Rua João", "87706443" );
    Customer customer2 = new Customer(idCustomer2, "Maria Cardoso", "44978682996", "07545268980", "maris2cardoso@hotmail.com", "Paranavaí", "Rua João", "87706443" );
    
    @AfterEach
    public void tearDown() {
        clearInvocations(service);
    }
    
    @Test
    public void mustReturnCustomerList_whenSuccesfull() {
        List<Customer> listCustomer = service.findAll();
        listCustomer.add(customer1);
        listCustomer.add(customer2);
        Assertions.assertTrue(listCustomer.contains(customer1));
        Assertions.assertTrue(listCustomer.contains(customer2));
    }
}
