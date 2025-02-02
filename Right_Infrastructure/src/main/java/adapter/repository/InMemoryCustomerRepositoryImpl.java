package adapter.repository;

import domain.Customer;
import domain.MemeberStatus;
import exception.CustomerNotFoundException;
import repository.ICustomerRepository;

import java.util.*;

public class InMemoryCustomerRepositoryImpl implements ICustomerRepository {
    private Map<Integer, Customer> dataStore = new HashMap<>();

    public Customer CreateCustomer(Customer customer) {

        customer.setCustomerId(RepositoryUtils.getPrimaryKey());
        customer.setRewardedpoints(500);
        customer.setStatus(MemeberStatus.BRONZE);

        dataStore.putIfAbsent(customer.getCustomerId(), customer);

        return customer;
    }

    public Customer UpdateCustomer(Customer customer) throws CustomerNotFoundException {

        if (!dataStore.containsKey(customer.getCustomerId())) {
            throw new CustomerNotFoundException("Customer " + customer.getCustomerId() + "can't be found");
        }

        dataStore.put(customer.getCustomerId(), customer);
        return customer;

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> all = new ArrayList<>();
        dataStore.values()
                .stream()
                .forEach(c -> all.add(c));
        return all;
    }

    @Override
    public Optional<Customer> findCustomerById(int customerId) {

        Optional<Customer> opt = Optional.empty();

        if (this.dataStore.containsKey(customerId)) {
            opt = Optional.of(dataStore.get(customerId));
        }
        return opt;
    }
}
