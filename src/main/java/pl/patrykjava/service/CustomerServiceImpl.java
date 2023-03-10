package pl.patrykjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.patrykjava.dao.CustomerDAO;
import pl.patrykjava.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers(int sortField) {
        return customerDAO.getCustomers(sortField);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String customerName) {
        return customerDAO.searchCustomers(customerName);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }
}
