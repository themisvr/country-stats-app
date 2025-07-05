package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.country.CountryDto;
import gr.qualco.demo.countrystats.dto.country.CountryEnhancedDto;
import gr.qualco.demo.countrystats.dto.country.CountryGdpPopulationDto;
import gr.qualco.demo.countrystats.entity.Country;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LanguageMapper.class, RegionEnhancedMapper.class, CountryStatMapper.class})
public interface CountryMapper extends BaseMapper<CountryDto, Country> {

    @Override
    @Mapping(target = "id", ignore = true)
    CountryDto toDto(Country entity);

    @Override
    List<CountryDto> toDtoList(List<Country> entities);

    @Mapping(source = "id.year", target = "year")
    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "country.countryCode3", target = "countryCode3")
    CountryGdpPopulationDto toStatisticsDto(CountryStat stat);

    @Mapping(source = "countryId", target = "id")
    @Mapping(source = "region", target = "region")
    @Mapping(source = "countryStats", target = "countryStats")
    CountryEnhancedDto toCountryEnhancedDto(Country entity);

    List<CountryEnhancedDto> toCountryEnhancedDtoList(List<Country> entities);
}
