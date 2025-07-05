package gr.qualco.demo.countrystats.dto.country.response;

import gr.qualco.demo.countrystats.dto.country.CountryGdpPopulationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCountriesMaxGdpPopulationRatioResponse {
    List<CountryGdpPopulationDto> countriesStats;
}
