package gr.qualco.demo.countrystats.dto.region.response;

import gr.qualco.demo.countrystats.dto.region.RegionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetRegionsResponse {
    List<RegionDto> regions;
}
