package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByCountryCode2(String countryCode2);

    @Query("SELECT c.id FROM Country c WHERE (:regionId IS NULL OR c.region.regionId = :regionId)")
    Page<Integer> findCountryIdsByRegionId(@Param("regionId") Integer regionId, Pageable pageable);

    @Query("""
    SELECT DISTINCT c FROM Country c
    LEFT JOIN FETCH c.countryStats cs
    WHERE c.id IN :countryIds
      AND (:yearFrom IS NULL OR cs.id.year >= :yearFrom)
      AND (:yearTo IS NULL OR cs.id.year <= :yearTo)
    """)
    List<Country> findCountriesWithDatesFiltered(
            @Param("countryIds") List<Integer> countryIds,
            @Param("yearFrom") Integer yearFrom,
            @Param("yearTo") Integer yearTo
    );
}
