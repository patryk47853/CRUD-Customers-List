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
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
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
}
