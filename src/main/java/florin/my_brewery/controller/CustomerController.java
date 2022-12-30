package florin.my_brewery.controller;

import florin.my_brewery.services.CustomerService;
import florin.my_brewery.web.model.CustomerDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> handlePost(CustomerDto customerDto) {
    CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

    return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody @Valid CustomerDto customerDto) {
    customerService.updateCustomer(customerId, customerDto);
  }

  @DeleteMapping("/{customerId}")
  public void deleteById(@PathVariable("customerId") UUID customerId) {
    customerService.deleteById(customerId);
  }


}
