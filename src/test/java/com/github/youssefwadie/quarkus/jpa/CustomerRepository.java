package com.github.youssefwadie.quarkus.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Optional;

@ApplicationScoped
public class CustomerRepository {
    @Inject
    EntityManager em;


    public void persist(Customer customer) {
        em.persist(customer);
    }

    public Optional<Customer> findById(Long id) {
        Customer customer = em.find(Customer.class, id);
        return Optional.ofNullable(customer);
    }
}
