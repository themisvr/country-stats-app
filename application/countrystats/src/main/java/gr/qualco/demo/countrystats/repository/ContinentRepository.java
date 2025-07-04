package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Integer> {
}
