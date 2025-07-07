package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStatId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {

    @Query("SELECT cs FROM CountryStat cs " +
            "JOIN FETCH cs.country c " +
            "JOIN FETCH c.region r " +
            "WHERE (:regionId IS NULL OR r.regionId = :regionId) " +
            "AND (:yearFrom IS NULL OR cs.id.year >= :yearFrom) " +
            "AND (:yearTo IS NULL OR cs.id.year <= :yearTo)")
    Page<CountryStat> getCountryStatsByRegionIdAndDates(@Param("regionId") Integer regionId,
                                                @Param("yearFrom") Integer yearFrom,
                                                @Param("yearTo") Integer yearTo,
                                                Pageable pageable
    );

}
