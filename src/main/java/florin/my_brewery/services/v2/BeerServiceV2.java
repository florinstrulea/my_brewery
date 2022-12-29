package florin.my_brewery.services.v2;

import florin.my_brewery.services.interfaces.v2.BeerRepoV2;
import florin.my_brewery.web.model.v2.BeerDtoV2;
import florin.my_brewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2 implements BeerRepoV2 {
  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    return BeerDtoV2.builder()
            .id(beerId)
            .beerName("Kastel Beer")
            .beerStyle(BeerStyleEnum.IPA)
            .build();


  }

  /**
   * This method saves a new beer
   *
   * @param beerDto it's an object that it is saved
   * @return It returns a BeerDto
   */
  @Override
  public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
    return BeerDtoV2.builder()
            .id(UUID.randomUUID())
            .beerName("Paix Dieux")
            .beerStyle(BeerStyleEnum.ALE)
            .build();
  }

  /**
   * @param beerId
   * @param beerDtoV2
   */
  @Override
  public void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2) {
    //todo impl - would add a real impl to update beer
  }

  @Override
  public void deleteById(UUID beerId) {
    log.debug("Deleting a beer...");
  }
}
