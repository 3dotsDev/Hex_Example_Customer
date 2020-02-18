package services;

import com.google.inject.Inject;
import domain.Customer;
import domain.MemeberStatus;
import exception.CustomerNotFoundException;
import repository.ICustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICustomerService {
    private ICustomerRepository repo;

    @Inject
    public CustomerService(ICustomerRepository respository) {
        repo = respository;
    }

    public Customer registerCustomer(Customer customer) {

        return repo.CreateCustomer(customer);

    }

    public Customer upgradeCustomer(Customer customer) throws CustomerNotFoundException {

        if (customer.getStatus() == MemeberStatus.BRONZE) {
            customer.setStatus(MemeberStatus.SILVER);
        } else if (customer.getStatus() == MemeberStatus.SILVER) {
            customer.setStatus(MemeberStatus.GOLD);
        } else if (customer.getStatus() == MemeberStatus.GOLD) {
            customer.setStatus(MemeberStatus.GOLD);
        }

        return repo.UpdateCustomer(customer);

    }

    public Customer downgradeCustomer(Customer customer) throws CustomerNotFoundException {

        if (customer.getStatus() == MemeberStatus.BRONZE) {
            customer.setStatus(MemeberStatus.BRONZE);
        } else if (customer.getStatus() == MemeberStatus.SILVER) {
            customer.setStatus(MemeberStatus.BRONZE);
        } else if (customer.getStatus() == MemeberStatus.GOLD) {
            customer.setStatus(MemeberStatus.SILVER);
        }

        return repo.UpdateCustomer(customer);

    }

    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    public Optional<Customer> findCustomerById(int customerId) {
        // TODO Auto-generated method stub
        return repo.findCustomerById(customerId);
    }

}
