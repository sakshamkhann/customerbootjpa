package com.cap.apps.customerbootjpa.repository;

import com.cap.apps.customerbootjpa.entities.Customer;

public interface CustomerRepository {
    public Customer add(Customer customer);
    public Customer update(Customer customer);
    public Customer findById(Long id);
 }
