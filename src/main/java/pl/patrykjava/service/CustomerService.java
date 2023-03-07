package pl.patrykjava.service;

import pl.patrykjava.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    List<Customer> searchCustomers(String customerName);

    void saveCustomer(Customer theCustomer);

}
