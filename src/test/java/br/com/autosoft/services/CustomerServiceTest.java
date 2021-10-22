package br.com.autosoft.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.autosoft.dtos.CustomerDTO;
import br.com.autosoft.entities.Customer;
import br.com.autosoft.repositories.CustomerRepository;
import br.com.autosoft.service.CustomerService;

@DataJpaTest
public class CustomerServiceTest {

    @Mock
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

    private static final Integer idCustomer1 = 1;
    private static final Integer idCustomer2 = 2;
    CustomerDTO customer1 = new CustomerDTO(idCustomer1, "Maicon Cardoso", "44991682996", "07545268980",
            "maiconscardoso@hotmail.com", "Paranavaí", "Rua João", "87706443");
    CustomerDTO customer2 = new CustomerDTO(idCustomer2, "Maria Cardoso", "44978682996", "07545268980",
            "maris2cardoso@hotmail.com", "Paranavaí", "Rua João", "87706443");
    Customer customer3 = new Customer();

    @Test
    public void mustReturnCustomerList_whenSuccesfull() {
        List<CustomerDTO> listCustomer = service.read();
        listCustomer.add(customer1);
        Assertions.assertTrue(listCustomer.contains(customer1));
    }

    @Test
    public void notMustReturnCustomerList_whenNotSuccesfull() {
        List<CustomerDTO> listCustomer = service.read();
        Assertions.assertFalse(listCustomer.contains(customer1));
        Assertions.assertFalse(listCustomer.contains(customer2));
    }

    @Test
    @DisplayName("Save persisits customer when succesfull")
    public void mustSaveCustomer_whenSuccesfull() {
        Customer customerToBeSaved = createCustomer();
        Customer customerSave = repository.save(customerToBeSaved);
        Assertions.assertNotNull(customerSave);
    }

    @Test
    @DisplayName("Find by id Customer when succesfull")
    public void mustReturnIdCustomer_whenSuccesfull() {
        Customer customerToBeSaved = createCustomer();
        Customer customerSaved = repository.save(customerToBeSaved);
        Integer idCustomer = customerSaved.getId();
        Customer customerFirst = this.repository.findById(idCustomer).get();
        Assertions.assertEquals(customerSaved.getId(), customerFirst.getId());
    }

    @Test
    @DisplayName("Delete customer")
    public void mustDeleteCustomer_whenSuccesfull() {
        Customer customer = createCustomer();
        Customer customerToBeSaved = this.repository.save(customer);
        Customer customerId = this.repository.findById(customerToBeSaved.getId()).get();
        this.repository.delete(customerId);
        Assertions.assertNotNull(customerId);
    }

    public Customer createCustomer() {
        return Customer.builder().id(3).name("Cliente").fone("991682996").email("cliente@email.com").cpf("870754885")
                .city("Cidade").cep("87075325").address("Rua do cliente").build();
    }
}
