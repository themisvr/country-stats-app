package gr.qualco.demo.countrystats.entity.countryStat;

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
public class StatisticsDto implements DtoInterface<CountryStatId> {

    private CountryStatId id;

    private String countryName;

    private String regionName;

    private String continentName;

    private Integer year;

    private Integer population;

    private BigDecimal gdp;
}
