package gr.qualco.demo.countrystats.service.statistics;

import gr.qualco.demo.countrystats.entity.countryStat.response.GetPaginatedStatisticsResponse;
import org.springframework.data.domain.Pageable;

public interface StatisticsServiceInterface {

    GetPaginatedStatisticsResponse getPaginatedStatistics(Integer regionId, Integer yearFrom, Integer yearTo, Pageable pageable);
}
