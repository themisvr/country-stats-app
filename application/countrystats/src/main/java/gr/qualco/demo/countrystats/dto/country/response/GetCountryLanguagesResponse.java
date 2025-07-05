package gr.qualco.demo.countrystats.dto.country.response;

import gr.qualco.demo.countrystats.dto.country.CountryLanguageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCountryLanguagesResponse {
    private List<CountryLanguageDto> countryLanguages;
}
