package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.country.CountryDto;
import gr.qualco.demo.countrystats.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = LanguageMapper.class)
public interface CountryMapper extends BaseMapper<CountryDto, Country> {

    @Override
    @Mapping(target = "id", ignore = true)
    CountryDto toDto(Country entity);

    @Override
    List<CountryDto> toDtoList(List<Country> entities);
}
