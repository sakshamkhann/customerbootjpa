package com.cap.apps.customerbootjpa.service;

import com.cap.apps.customerbootjpa.entities.Customer;

public interface CustomerService {
    public Customer register(Customer customer);
    public Customer updateName(Customer customer);
    public Customer findById(Long id);

}
