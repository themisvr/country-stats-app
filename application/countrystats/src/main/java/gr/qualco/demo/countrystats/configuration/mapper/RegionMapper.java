package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.region.RegionDto;
import gr.qualco.demo.countrystats.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper extends BaseMapper<RegionDto, Region> {

    @Override
    @Mapping(source = "regionId", target = "id")
    RegionDto toDto(Region entity);

    @Override
    List<RegionDto> toDtoList(List<Region> entities);
}
