package gr.qualco.demo.countrystats.service.country;

import gr.qualco.demo.countrystats.dto.country.CountryEnhancedDto;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesMaxGdpPopulationRatioResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountryLanguagesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryServiceInterface {

    GetCountriesResponse getCountries();

    GetCountryLanguagesResponse getCountryLanguages(String countryCode2);

    GetCountriesMaxGdpPopulationRatioResponse getCountriesMaxGdpPopulationRatio();

    Page<CountryEnhancedDto> getCountriesRegions(Integer regionId, Integer yearFrom, Integer yearTo, Pageable pageable);
}
