package florin.my_brewery.services.interfaces.v2;

import florin.my_brewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerRepoV2 {
  BeerDtoV2 getBeerById(UUID beerId);

  BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

  void updateBeer(UUID beerId, BeerDtoV2 beerDto);
  
  void deleteById(UUID beerId);
}
