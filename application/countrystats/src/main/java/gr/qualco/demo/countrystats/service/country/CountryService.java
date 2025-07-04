package gr.qualco.demo.countrystats.service.country;

import gr.qualco.demo.countrystats.configuration.mapper.CountryLanguageMapper;
import gr.qualco.demo.countrystats.configuration.mapper.CountryMapper;
import gr.qualco.demo.countrystats.dto.country.CountryDto;
import gr.qualco.demo.countrystats.dto.country.CountryLanguageDto;
import gr.qualco.demo.countrystats.dto.country.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.GetCountryLanguagesResponse;
import gr.qualco.demo.countrystats.entity.Country;
import gr.qualco.demo.countrystats.repository.CountryRepository;
import gr.qualco.demo.countrystats.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CountryService extends BaseService<CountryDto, Country, Integer, CountryRepository, CountryMapper> implements CountryServiceInterface {

    private final CountryLanguageMapper countryLanguageMapper;

    public CountryService(CountryRepository repository, CountryMapper mapper,
                          CountryLanguageMapper countryLanguageMapper) {
        super(repository, mapper);
        this.countryLanguageMapper = countryLanguageMapper;
    }

    @Override
    public GetCountriesResponse getCountries() {
        List<CountryDto> countriesDtoList = findAll();

        countriesDtoList.sort(Comparator.comparing(CountryDto::getName));

        return GetCountriesResponse.builder()
                .countries(countriesDtoList)
                .build();
    }

    @Override
    public GetCountryLanguagesResponse getCountryLanguages(String countryCode2) {
        List<CountryLanguageDto> countryLanguages = this.repository.findByCountryCode2(countryCode2)
                .map(country -> countryLanguageMapper.toDtoList(country.getCountryLanguages()))
                .orElse(Collections.emptyList());

        return GetCountryLanguagesResponse.builder()
                .countryLanguages(countryLanguages)
                .build();
    }
}
