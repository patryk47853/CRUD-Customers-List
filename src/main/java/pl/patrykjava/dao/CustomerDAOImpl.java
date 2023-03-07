package pl.patrykjava.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.patrykjava.entity.Customer;

import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query myQuery = currentSession.createQuery("from Customer", Customer.class);

        List<Customer> myCustomers = myQuery.getResultList();

        return myCustomers;
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
}
