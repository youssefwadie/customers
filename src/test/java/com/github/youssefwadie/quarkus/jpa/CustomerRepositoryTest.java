package com.github.youssefwadie.quarkus.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindCustomer() {
        Customer customer = new Customer("Youssef", "Wadie", "youssef@mail.com");
        repository.persist(customer);
        assertNotNull(customer.getId());

        Optional<Customer> optionalCustomerFromDB = repository.findById(customer.getId());
        assertTrue(optionalCustomerFromDB.isPresent());

        Customer customerFromDB = optionalCustomerFromDB.get();

        assertEquals(customer.getFirstName(), customerFromDB.getFirstName());
        assertEquals(customer.getLastName(), customerFromDB.getLastName());
        assertEquals(customer.getEmail(), customerFromDB.getEmail());
        assertNotNull(customerFromDB.getCreatedDate());

    }

}
