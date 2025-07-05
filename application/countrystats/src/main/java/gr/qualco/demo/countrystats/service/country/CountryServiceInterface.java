package gr.qualco.demo.countrystats.service.country;

import gr.qualco.demo.countrystats.dto.country.response.GetCountriesMaxGdpPopulationRatioResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountryLanguagesResponse;

public interface CountryServiceInterface {

    GetCountriesResponse getCountries();

    GetCountryLanguagesResponse getCountryLanguages(String countryCode2);

    GetCountriesMaxGdpPopulationRatioResponse getCountriesMaxGdpPopulationRatio();
}
