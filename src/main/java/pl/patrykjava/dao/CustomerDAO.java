package pl.patrykjava.dao;

import pl.patrykjava.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    List<Customer> searchCustomers(String customerName);
}
