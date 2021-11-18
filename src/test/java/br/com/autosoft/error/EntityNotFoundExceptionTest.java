package br.com.autosoft.error;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.autosoft.controller.CustomerController;
import br.com.autosoft.entities.Customer;

class EntityNotFoundExceptionTest {


	@Mock
	EntityNotFoundExceptionTest entityNotFoundExceptionTest;

	@Autowired
    private CustomerController controller;

    Customer customerToBeSaved;
    ResponseEntity<Customer> customerSave;

    public Customer createCustomer() {
        return Customer.builder().id(1).name("Cliente").fone("991682996").email("cliente@email.com").cpf("870754885")
                .city("Cidade").cep("87075325").address("Rua do cliente").build();
    }

    @BeforeEach
    public void setup() {
        customerToBeSaved = createCustomer();
        customerSave = controller.save(customerToBeSaved);
    }

	// @Test
	// void mustReturnMessageException_whenNotSuccesfull() {
	// 	Assertions.assertThrows(entityNotFoundExceptionTest);
	// }

}
