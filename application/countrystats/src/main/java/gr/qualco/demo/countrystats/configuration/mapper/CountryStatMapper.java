package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.country.CountryStatDto;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryStatMapper extends BaseMapper<CountryStatDto, CountryStat> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "id.year", target = "year")
    CountryStatDto toDto(CountryStat entity);

    @Override
    List<CountryStatDto> toDtoList(List<CountryStat> entities);
}
