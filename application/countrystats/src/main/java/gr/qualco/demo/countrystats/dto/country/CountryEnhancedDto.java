package gr.qualco.demo.countrystats.dto.country;

import gr.qualco.demo.countrystats.dto.DtoInterface;
import gr.qualco.demo.countrystats.dto.region.RegionEnhancedDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryEnhancedDto implements DtoInterface<Integer> {

    private Integer id;

    private String name;

    private RegionEnhancedDto region;

    private List<CountryStatDto> countryStats;
}
