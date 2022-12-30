package florin.my_brewery.web.mappers;

import florin.my_brewery.domain.Customer;
import florin.my_brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
  public CustomerDto customerToCustomerDto(Customer customer);

  public Customer customerDtoToCustomer(Customer customerDto);
}
