package gr.qualco.demo.countrystats.controller;

import gr.qualco.demo.countrystats.dto.country.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.GetCountryLanguagesResponse;
import gr.qualco.demo.countrystats.service.country.CountryServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryServiceInterface countryService;

    public CountryController(CountryServiceInterface countryServiceInterface) {
        this.countryService = countryServiceInterface;
    }

    @GetMapping
    public ResponseEntity<GetCountriesResponse> getCountries() {
        GetCountriesResponse response = countryService.getCountries();

        if (response.getCountries().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("{countryCode2}/languages")
    public ResponseEntity<GetCountryLanguagesResponse> getCountryLanguages(@PathVariable String countryCode2) {
        GetCountryLanguagesResponse response = countryService.getCountryLanguages(countryCode2);

        return ResponseEntity.ok(response);
    }


}
