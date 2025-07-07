package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import gr.qualco.demo.countrystats.entity.countryStat.StatisticsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatisticsMapper extends BaseMapper<StatisticsDto, CountryStat> {


    @Override
    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "country.region.name", target = "regionName")
    @Mapping(source = "country.region.continent.name", target = "continentName")
    @Mapping(source = "id.year", target = "year")
    StatisticsDto toDto(CountryStat entity);

    @Override
    List<StatisticsDto> toDtoList(List<CountryStat> entities);
}
