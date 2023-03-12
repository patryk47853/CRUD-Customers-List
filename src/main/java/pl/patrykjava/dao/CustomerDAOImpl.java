package pl.patrykjava.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.patrykjava.SortingValues;
import pl.patrykjava.entity.Customer;

import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(int sortField) {

        Session currentSession = sessionFactory.getCurrentSession();

        String fieldToSort = null;

        switch (sortField) {
            case SortingValues.FIRST_NAME:
                fieldToSort = "firstName";
                break;
            case SortingValues.LAST_NAME:
                fieldToSort = "lastName";
                break;
            case SortingValues.EMAIL:
                fieldToSort = "email";
                break;
            default:
                // as default, just sort by last name
                fieldToSort = "lastName";
        }

        String sortQuery = "from Customer order by " + fieldToSort;
        Query myQuery = currentSession.createQuery(sortQuery, Customer.class);

        List<Customer> myCustomers = myQuery.getResultList();

        return myCustomers;
    }

    @Override
    public Customer getCustomer(int customerId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Customer myCustomer = currentSession.get(Customer.class, customerId);

        return myCustomer;
    }

    @Override
    public List<Customer> searchCustomers(String customerName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query customerQuery = null;

        if (customerName != null && customerName.trim().length() > 0) {
            customerQuery = currentSession.createQuery("from Customer " +
                    "where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            customerQuery.setParameter("theName", "%" + customerName.toLowerCase() + "%");
        } else {
            customerQuery = currentSession.createQuery("from Customer", Customer.class);
        }

        List<Customer> myCustomers = customerQuery.getResultList();

        return myCustomers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session currenSession = sessionFactory.getCurrentSession();

        Customer theCustomer = currenSession.get(Customer.class, customerId);

        currenSession.delete(theCustomer);
    }
}
