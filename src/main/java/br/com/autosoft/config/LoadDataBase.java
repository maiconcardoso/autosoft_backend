package br.com.autosoft.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.autosoft.entities.Customer;
import br.com.autosoft.repositories.CustomerRepository;
import br.com.autosoft.repositories.OrderRepository;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Autowired
    CustomerRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            log.info(
                "Preloading " + clientRepository.save(new Customer(null, "Carlos Alberto", "44991682996", "07545268980", "maiconscardoso@hotmail.com", "Paranavaí", "Rua João", "87706443" ))
            );
            log.info(
                "Preloading " + clientRepository.save(new Customer(null, "Ana Maria de Nobrega", "44978682996", "07545268980", "maris2cardoso@hotmail.com", "Paranavaí", "Rua João", "87706443" ))
            );
        };
    }
}
