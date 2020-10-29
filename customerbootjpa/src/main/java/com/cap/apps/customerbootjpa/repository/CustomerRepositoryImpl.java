package com.cap.apps.customerbootjpa.repository;

import com.cap.apps.customerbootjpa.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer add(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    public Customer update(Customer customer) {
       entityManager.merge(customer);
        return customer;
    }

    public Customer findById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }


}
