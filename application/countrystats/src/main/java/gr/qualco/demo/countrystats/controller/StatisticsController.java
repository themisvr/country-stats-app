package gr.qualco.demo.countrystats.controller;

import gr.qualco.demo.countrystats.entity.countryStat.response.GetPaginatedStatisticsResponse;
import gr.qualco.demo.countrystats.service.statistics.StatisticsServiceInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class StatisticsController {

    private final StatisticsServiceInterface statisticsService;

    public StatisticsController(StatisticsServiceInterface statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public ResponseEntity<GetPaginatedStatisticsResponse> getPaginatedStatistics(@RequestParam(required = false) Integer regionId,
                                                                                       @RequestParam(required = false) Integer yearFrom,
                                                                                       @RequestParam(required = false) Integer yearTo,
                                                                                       Pageable pageable
    ) {
        GetPaginatedStatisticsResponse response = statisticsService.getPaginatedStatistics(regionId, yearFrom, yearTo, pageable);

        return ResponseEntity.ok(response);
    }
}
