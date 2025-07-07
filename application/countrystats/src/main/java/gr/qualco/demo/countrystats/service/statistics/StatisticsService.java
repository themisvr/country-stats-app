package gr.qualco.demo.countrystats.service.statistics;

import gr.qualco.demo.countrystats.configuration.mapper.StatisticsMapper;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStatId;
import gr.qualco.demo.countrystats.entity.countryStat.StatisticsDto;
import gr.qualco.demo.countrystats.entity.countryStat.response.GetPaginatedStatisticsResponse;
import gr.qualco.demo.countrystats.exception.InvalidYearRangeException;
import gr.qualco.demo.countrystats.repository.CountryStatRepository;
import gr.qualco.demo.countrystats.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class StatisticsService extends BaseService<StatisticsDto, CountryStat, CountryStatId, CountryStatRepository, StatisticsMapper>
        implements StatisticsServiceInterface {

    public StatisticsService(CountryStatRepository repository, StatisticsMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public GetPaginatedStatisticsResponse getPaginatedStatistics(Integer regionId, Integer yearFrom, Integer yearTo, Pageable pageable) {

        validateYearRange(yearFrom, yearTo);

        Page<CountryStat> countryStatsFiltered = repository.getCountryStatsByRegionIdAndDates(regionId, yearFrom, yearTo, pageable);

        List<StatisticsDto> statisticsDtos = mapper.toDtoList(countryStatsFiltered.getContent().stream().toList());
        statisticsDtos.sort(Comparator.comparing(StatisticsDto::getYear));

        Page<StatisticsDto> statistics = new PageImpl<>(statisticsDtos, pageable, countryStatsFiltered.getTotalElements());

        return GetPaginatedStatisticsResponse.builder()
                .stats(statistics)
                .build();
    }

    private void validateYearRange(Integer yearFrom, Integer yearTo) {
        if (Objects.nonNull(yearFrom) && Objects.nonNull(yearTo)) {
            if (yearFrom > yearTo) {
                throw new InvalidYearRangeException("Year From cannot be greater than Year To.");
            }
        }
    }
}
