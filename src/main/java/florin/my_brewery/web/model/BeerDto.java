package florin.my_brewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created 26/12/2022
 **/
@Data //getters and setters + hashcode and equals methods
@NoArgsConstructor //constructor with no arguments
@AllArgsConstructor //constructor with all the arguments
@Builder //implements the build pattern
public class BeerDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
