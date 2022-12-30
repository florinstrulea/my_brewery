package florin.my_brewery.controller.v2;

import florin.my_brewery.services.v2.BeerServiceV2;
import florin.my_brewery.web.model.v2.BeerDtoV2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v2/beer")
public class BeerConrollerV2 {

  private final BeerServiceV2 beerServiceV2;

  public BeerConrollerV2(BeerServiceV2 beerServiceV2) {
    this.beerServiceV2 = beerServiceV2;
  }


  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<BeerDtoV2>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping("/{beerId}")
  public ResponseEntity<String> handlePost(@Valid @RequestBody @NotNull BeerDtoV2 beerDtoV2) {
    BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);
    HttpHeaders httpHeaders = new HttpHeaders();
    //TODO add hostname to url
    httpHeaders.add("Location", "/api/v1/beer" + savedDto.getId().toString());
    return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping({"/{beerId}"})
  public ResponseEntity<String> handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtoV2) {

    beerServiceV2.updateBeer(beerId, beerDtoV2);

    return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping({"/{beerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerServiceV2.deleteById(beerId);
  }
  
}
