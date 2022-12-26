package florin.my_brewery.services.interfaces;

import florin.my_brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerRepo {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);
}
