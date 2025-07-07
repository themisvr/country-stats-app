package gr.qualco.demo.countrystats.entity.countryStat.response;

import gr.qualco.demo.countrystats.entity.countryStat.StatisticsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPaginatedStatisticsResponse {
    private Page<StatisticsDto> stats;
}
