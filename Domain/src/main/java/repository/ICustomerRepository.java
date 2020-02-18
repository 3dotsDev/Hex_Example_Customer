package repository;

import domain.Customer;
import exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    public Customer CreateCustomer(Customer customer);

    public Customer UpdateCustomer(Customer customer) throws CustomerNotFoundException;

    public List<Customer> findAll();

    public Optional<Customer> findCustomerById(int customerId);
}
