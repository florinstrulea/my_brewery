package florin.my_brewery.services.interfaces;

import florin.my_brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerRepo {
    public CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);

}
