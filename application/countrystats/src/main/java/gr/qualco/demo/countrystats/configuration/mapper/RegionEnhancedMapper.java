package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.region.RegionEnhancedDto;
import gr.qualco.demo.countrystats.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionEnhancedMapper extends BaseMapper<RegionEnhancedDto, Region> {

    @Override
    @Mapping(source = "regionId", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "continent.name", target = "continentName")
    RegionEnhancedDto toDto(Region entity);

    @Override
    List<RegionEnhancedDto> toDtoList(List<Region> entities);
}
