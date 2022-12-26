package florin.my_brewery.services;

import florin.my_brewery.services.interfaces.CustomerRepo;
import florin.my_brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService implements CustomerRepo {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("John Snow")
                .build();
    }
}
