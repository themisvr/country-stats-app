package gr.qualco.demo.countrystats.dto.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryGdpPopulationDto {

    private String countryName;

    private String countryCode3;

    private Integer year;

    private Integer population;

    private BigDecimal gdp;
}
