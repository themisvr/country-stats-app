package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByCountryCode2(String countryCode2);
}
