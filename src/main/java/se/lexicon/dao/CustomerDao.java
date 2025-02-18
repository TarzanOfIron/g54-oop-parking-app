package se.lexicon.dao;

import se.lexicon.model.Customer;

import java.util.Optional;

public interface CustomerDao {

    Customer create(Customer customer);

    Customer findById(Integer id);

}
