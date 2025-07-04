package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.countryLanguage.CountryLanguage;
import gr.qualco.demo.countrystats.entity.countryLanguage.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
}
