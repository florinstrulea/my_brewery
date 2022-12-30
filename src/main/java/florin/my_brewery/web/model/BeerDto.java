package florin.my_brewery.web.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created 26/12/2022
 **/
@Data //getters and setters + hashcode and equals methods
@NoArgsConstructor //constructor with no arguments
@AllArgsConstructor //constructor with all the arguments
@Builder //implements the build pattern
public class BeerDto {
  @Null
  private UUID id;

  @NotBlank
  private String beerName;
  @NotBlank
  private String beerStyle;
  @Positive
  private Long upc;

  private OffsetDateTime createdDate;
  private OffsetDateTime lastUpdateDate;
}
