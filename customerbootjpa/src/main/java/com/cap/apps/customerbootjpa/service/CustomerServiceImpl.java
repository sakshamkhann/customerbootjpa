package com.cap.apps.customerbootjpa.service;

import com.cap.apps.customerbootjpa.entities.Customer;
import com.cap.apps.customerbootjpa.repository.CustomerRepository;
import com.cap.apps.customerbootjpa.util.ValidateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer register(Customer customer) {
        ValidateCustomer.checkName(customer.getName());
        repo.add(customer);
        return customer;
    }

    public Customer updateName(Customer customer)  {
        ValidateCustomer.checkName(customer.getName());
        ValidateCustomer.checkId(customer.getId());
        Customer customerFind = findById(customer.getId());
        ValidateCustomer.checkCustomerExist(customerFind);
        customerFind.setName(customer.getName());
        repo.update(customerFind);
        return customer;
    }

    public Customer findById(Long id) {
        Customer customer = repo.findById(id);
        return customer;
    }
    /*public Customer checkExists(Customer customer){
        try{
        ValidateCustomer.checkCustomerExist(customer);
        }
        catch (CustomerNotExistException e){
            Customer newCustomer = new Customer();
            return newCustomer;
        }
        return customer;
    }*/
}
