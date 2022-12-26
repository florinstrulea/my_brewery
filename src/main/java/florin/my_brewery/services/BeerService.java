package florin.my_brewery.services;

import florin.my_brewery.services.interfaces.BeerRepo;
import florin.my_brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerService implements BeerRepo {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .beerName("Kastel Beer")
                .beerStyle("Fruity")
                .build();
    }
}
