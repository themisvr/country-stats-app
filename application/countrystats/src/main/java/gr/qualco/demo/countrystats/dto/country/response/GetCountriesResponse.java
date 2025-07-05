package gr.qualco.demo.countrystats.dto.country.response;

import gr.qualco.demo.countrystats.dto.country.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCountriesResponse {

    List<CountryDto> countries;
}
