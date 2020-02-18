package adapter.console;

import adapter.repository.InMemoryCustomerRepositoryImpl;
import com.google.inject.AbstractModule;
import repository.ICustomerRepository;
import services.CustomerService;
import services.ICustomerService;

public class CommandConsoleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ICustomerRepository.class).to(InMemoryCustomerRepositoryImpl.class);
        bind(ICustomerService.class).to(CustomerService.class);
        bind(ICommand.class).to(Command.class);
    }
}
