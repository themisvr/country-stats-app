package gr.qualco.demo.countrystats.dto.region;

import gr.qualco.demo.countrystats.dto.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionDto implements DtoInterface<Integer> {

    private Integer id;

    private String name;
}
