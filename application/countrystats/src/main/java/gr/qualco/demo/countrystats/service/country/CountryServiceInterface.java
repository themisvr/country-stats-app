package gr.qualco.demo.countrystats.service.country;

import gr.qualco.demo.countrystats.dto.country.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.GetCountryLanguagesResponse;

public interface CountryServiceInterface {

    GetCountriesResponse getCountries();

    GetCountryLanguagesResponse getCountryLanguages(String countryCode2);
}
