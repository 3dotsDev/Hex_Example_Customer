package services;

import domain.Customer;
import exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public Customer registerCustomer(Customer customer);

    public Customer upgradeCustomer(Customer customer) throws CustomerNotFoundException;

    public Customer downgradeCustomer(Customer customer) throws CustomerNotFoundException;

    public List<Customer> getAllCustomers();

    public Optional<Customer> findCustomerById(int customerId);
}
