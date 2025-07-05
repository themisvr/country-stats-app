package gr.qualco.demo.countrystats.controller;

import gr.qualco.demo.countrystats.dto.country.CountryEnhancedDto;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesMaxGdpPopulationRatioResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountryLanguagesResponse;
import gr.qualco.demo.countrystats.service.country.CountryServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        return ResponseEntity.ok(response);
    }

    @GetMapping("{countryCode2}/languages")
    public ResponseEntity<GetCountryLanguagesResponse> getCountryLanguages(@PathVariable String countryCode2) {
        GetCountryLanguagesResponse response = countryService.getCountryLanguages(countryCode2);

        return ResponseEntity.ok(response);
    }

    @GetMapping("statistics")
    public ResponseEntity<GetCountriesMaxGdpPopulationRatioResponse> getCountriesMaxGdpPopulationRatio() {
        GetCountriesMaxGdpPopulationRatioResponse response = countryService.getCountriesMaxGdpPopulationRatio();

        return ResponseEntity.ok(response);
    }

    @GetMapping("regions")
    public ResponseEntity<Page<CountryEnhancedDto>> getCountriesRegions(@RequestParam(required = false) Integer regionId,
                                                                             @RequestParam(required = false) Integer yearFrom,
                                                                             @RequestParam(required = false) Integer yearTo,
                                                                             Pageable pageable) {
        Page<CountryEnhancedDto> response = countryService.getCountriesRegions(regionId, yearFrom, yearTo, pageable);

        return ResponseEntity.ok(response);
    }
}
