package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
