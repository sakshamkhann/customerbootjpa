package com.cap.apps.customerbootjpa.ui;


import com.cap.apps.customerbootjpa.entities.Customer;
import com.cap.apps.customerbootjpa.exceptions.CustomerIdException;
import com.cap.apps.customerbootjpa.exceptions.CustomerNameException;
import com.cap.apps.customerbootjpa.exceptions.CustomerNotExistException;
import com.cap.apps.customerbootjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;

@Component
public class ProjectUI {

    @Autowired
    private CustomerService service;

    public void runui(){
        try {



        Customer customer1 = register("Saksham");
        Customer customer2 = register("suraj");
        customer2.setName("sushi");
        Customer updateNonExistCustomer = updateName(customer2);
        System.out.println(customer1);
        System.out.println(customer2);
        customer2.setName("sunil");
        System.out.println("---Updated customer 2---");
        
        Customer customerUpdated2 = updateName(customer2);
        System.out.println(customerUpdated2);
        System.out.println("---Updated Non Existing Customer---");
        System.out.println(updateNonExistCustomer);
        Customer customer3 = register("");
        Customer nullCustomer1 = register("");
        String name=null;
        Customer nullCustomer2 = register(name);
        }
        catch(CustomerIdException e){
            System.out.println(e.getMessage());
        }
        catch(CustomerNotExistException e){
            System.out.println(e.getMessage());
        }
        catch(CustomerNameException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    public Customer register(String name){
        Customer customer =  new Customer(name);
        customer = service.register(customer);
        return customer;
    }
    public Customer updateName(Customer customer){
        Customer customerUpdated = service.updateName(customer);
        return customer;
    }

}

