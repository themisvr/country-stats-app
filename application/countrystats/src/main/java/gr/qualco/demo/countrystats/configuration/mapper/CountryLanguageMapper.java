package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.country.CountryLanguageDto;
import gr.qualco.demo.countrystats.entity.countryLanguage.CountryLanguage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryLanguageMapper extends BaseMapper<CountryLanguageDto, CountryLanguage> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "language.language", target = "languageName")
    CountryLanguageDto toDto(CountryLanguage entity);

    @Override
    List<CountryLanguageDto> toDtoList(List<CountryLanguage> entities);
}
