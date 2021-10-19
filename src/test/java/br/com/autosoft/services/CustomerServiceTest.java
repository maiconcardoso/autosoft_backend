package br.com.autosoft.services;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.autosoft.dtos.CustomerDTO;
import br.com.autosoft.service.CustomerService;

@DataJpaTest
public class CustomerServiceTest {
    
    @Mock
    private CustomerService service;
    
    private static final Integer idCustomer1 = 1;
    private static final Integer idCustomer2 = 2;
    CustomerDTO customer1 = new CustomerDTO(idCustomer1, "Maicon Cardoso", "44991682996", "07545268980", "maiconscardoso@hotmail.com", "Paranavaí", "Rua João", "87706443" );
    CustomerDTO customer2 = new CustomerDTO(idCustomer2, "Maria Cardoso", "44978682996", "07545268980", "maris2cardoso@hotmail.com", "Paranavaí", "Rua João", "87706443" );
    
    @Test
    public void mustReturnCustomerList_whenSuccesfull() {
        List<CustomerDTO> listCustomer = service.read();
        listCustomer.add(customer1);
        listCustomer.add(customer2);
        Assertions.assertTrue(listCustomer.contains(customer1));
        Assertions.assertTrue(listCustomer.contains(customer2));
    }
}
