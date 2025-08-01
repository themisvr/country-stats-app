package gr.qualco.demo.countrystats.service.country;

import gr.qualco.demo.countrystats.configuration.mapper.CountryLanguageMapper;
import gr.qualco.demo.countrystats.configuration.mapper.CountryMapper;
import gr.qualco.demo.countrystats.dto.country.CountryDto;
import gr.qualco.demo.countrystats.dto.country.CountryEnhancedDto;
import gr.qualco.demo.countrystats.dto.country.CountryGdpPopulationDto;
import gr.qualco.demo.countrystats.dto.country.CountryLanguageDto;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesMaxGdpPopulationRatioResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountriesResponse;
import gr.qualco.demo.countrystats.dto.country.response.GetCountryLanguagesResponse;
import gr.qualco.demo.countrystats.entity.Country;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import gr.qualco.demo.countrystats.exception.InvalidYearRangeException;
import gr.qualco.demo.countrystats.repository.CountryRepository;
import gr.qualco.demo.countrystats.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<CountryDto> countriesDtoList = findAllDto();

        countriesDtoList.sort(Comparator.comparing(CountryDto::getName));

        return GetCountriesResponse.builder()
                .countries(countriesDtoList)
                .build();
    }

    @Override
    public GetCountryLanguagesResponse getCountryLanguages(String countryCode2) {
        List<CountryLanguageDto> countryLanguages = repository.findByCountryCode2(countryCode2)
                .map(country -> countryLanguageMapper.toDtoList(country.getCountryLanguages()))
                .orElse(Collections.emptyList());

        return GetCountryLanguagesResponse.builder()
                .countryLanguages(countryLanguages)
                .build();
    }

    @Override
    public GetCountriesMaxGdpPopulationRatioResponse getCountriesMaxGdpPopulationRatio() {
        List<Country> countries = findAllEntity();

        List<CountryGdpPopulationDto> countriesGdpPopulationDtos = countries.stream()
                        .map(country -> {
                            CountryStat maxStat = findMaxGdpPopulationRatio(country.getCountryStats());

                            if (maxStat != null) {
                                return mapper.toStatisticsDto(maxStat);
                            }

                            return null;
                        })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return GetCountriesMaxGdpPopulationRatioResponse.builder()
                .countriesStats(countriesGdpPopulationDtos)
                .build();
    }

    @Override
    public Page<CountryEnhancedDto> getCountriesRegions(Integer regionId,
                                                        Integer yearFrom,
                                                        Integer yearTo,
                                                        Pageable pageable) {
        validateYearRange(yearFrom, yearTo);

        Page<Integer> countryIds = repository.findCountryIdsByRegionId(regionId, pageable);

        if (countryIds.isEmpty()) {
            return Page.empty();
        }

        List<Country> filteredCountries = repository.findCountriesWithDatesFiltered(countryIds.stream().toList(), yearFrom, yearTo);

        List<CountryEnhancedDto> dtoList = filteredCountries.stream()
                .map(mapper::toCountryEnhancedDto)
                .toList();

        return new PageImpl<>(dtoList, pageable, countryIds.getTotalElements());
    }

    private CountryStat findMaxGdpPopulationRatio(List<CountryStat> countryStats) {
        return countryStats.stream()
                .filter(stat -> stat.getPopulation() != null && stat.getPopulation() > 0 && stat.getGdp() != null)
                .max(Comparator.comparing(stat -> stat.getGdp().divide(
                        BigDecimal.valueOf(stat.getPopulation()), 6, RoundingMode.HALF_UP)))
                .orElse(null);
    }

    private void validateYearRange(Integer yearFrom, Integer yearTo) {
        if (Objects.nonNull(yearFrom) && Objects.nonNull(yearTo)) {
            if (yearFrom > yearTo) {
                throw new InvalidYearRangeException("Year From cannot be greater than Year To.");
            }
        }
    }
}
