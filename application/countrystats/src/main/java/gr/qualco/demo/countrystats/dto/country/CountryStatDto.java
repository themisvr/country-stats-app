package gr.qualco.demo.countrystats.dto.country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.qualco.demo.countrystats.dto.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryStatDto implements DtoInterface<Integer> {

    @JsonIgnore
    private Integer id;

    private Integer year;

    private Integer population;

    private BigDecimal gdp;
}
