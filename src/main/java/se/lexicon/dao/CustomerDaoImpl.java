package se.lexicon.dao;

import se.lexicon.dao.sequencer.CustomerIdSequencer;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> storage = new ArrayList<>(); // in-memory storage


    @Override
    public Customer create(Customer customer) {
        // validate the customer object
        if (customer == null) throw new IllegalArgumentException("Customer should not be null");
        // generate a unique id for customer then assign to customer data (setId)
        customer.setId(CustomerIdSequencer.nextId());
        // add to storage
        storage.add(customer);
        // return the created or inserted customer
        return customer;
    }

    @Override
    public Customer findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Customer Id should not be null.");
        for (Customer customer : storage) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
        //return storage.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

}
