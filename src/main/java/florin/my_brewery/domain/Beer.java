package florin.my_brewery.domain;

import florin.my_brewery.web.model.v2.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data //getters and setters + hashcode and equals methods
@NoArgsConstructor //constructor with no arguments
@AllArgsConstructor //constructor with all the arguments
@Builder
public class Beer {
  private UUID id;
  private String beerName;
  private BeerStyleEnum beerStyle;
  private Long upc;

  private Timestamp createdDate;
  private Timestamp lastUpdateDate;

}
