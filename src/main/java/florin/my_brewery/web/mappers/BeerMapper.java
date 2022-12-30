package florin.my_brewery.web.mappers;

import florin.my_brewery.domain.Beer;
import florin.my_brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

  BeerDto beerToBeerDto(Beer beer);

  Beer beerDtoToBeer(BeerDto beerDto);
}
