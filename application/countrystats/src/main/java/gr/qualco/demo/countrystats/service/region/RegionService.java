package gr.qualco.demo.countrystats.service.region;

import gr.qualco.demo.countrystats.configuration.mapper.RegionMapper;
import gr.qualco.demo.countrystats.dto.region.RegionDto;
import gr.qualco.demo.countrystats.dto.region.response.GetRegionsResponse;
import gr.qualco.demo.countrystats.entity.Region;
import gr.qualco.demo.countrystats.repository.RegionRepository;
import gr.qualco.demo.countrystats.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService extends BaseService<RegionDto, Region, Integer, RegionRepository, RegionMapper> implements RegionServiceInterface {

    public RegionService(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public GetRegionsResponse getRegions() {
        List<RegionDto> regions = findAllDto();

        return GetRegionsResponse.builder()
                .regions(regions)
                .build();
    }
}
