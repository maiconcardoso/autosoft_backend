package br.com.autosoft.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.autosoft.dtos.CustomerDTO;
import br.com.autosoft.entities.Customer;
import br.com.autosoft.exceptions.EntityNotFoundException;
import br.com.autosoft.repositories.CustomerRepository;
import br.com.autosoft.service.CustomerService;

@DataJpaTest
public class CustomerServiceTest {

    @Mock
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

    @Test
    public void mustSavedAndReturnCustomerList_whenSuccesfull() {
        Customer customerToBeSaved = createCustomer();
        Customer customerSave = repository.save(customerToBeSaved);
        List<Customer> listCustomer = repository.findAll(); 
        Assertions.assertTrue(listCustomer.contains(customerSave));
    }

    @Test
    @DisplayName("Find by id Customer when succesfull")
    public void mustSavedAndReturnIdCustomer_whenSuccesfull() {
        Customer customerToBeSaved = createCustomer();
        Customer customerSave = repository.save(customerToBeSaved);
        Customer customerById = repository.findById(customerSave.getId()).get();
        Assertions.assertEquals(customerById.getId(), customerSave.getId());
    }

    @Test
    @DisplayName("Delete customer")
    public void mustDeleteCustomer_whenSuccesfull() {
        Customer customerToBeSaved = createCustomer();
        Customer customerSave = repository.save(customerToBeSaved);
        repository.delete(customerSave);
    }

    public Customer createCustomer() {
        return Customer.builder().id(3).name("Cliente").fone("991682996").email("cliente@email.com").cpf("870754885")
                .city("Cidade").cep("87075325").address("Rua do cliente").build();
    }

    public CustomerDTO convertCustomerForCustomerDTO() {
        Customer customer = createCustomer();
        Customer customerToBeSaved = repository.save(customer);
        Optional<Customer> customerSave = repository.findById(customerToBeSaved.getId());
        return customerSave.stream()
            .map((obj) -> new CustomerDTO(obj)).findFirst().orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.MESSAGE));
    }
}
