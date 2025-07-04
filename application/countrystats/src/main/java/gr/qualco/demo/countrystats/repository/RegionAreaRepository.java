package gr.qualco.demo.countrystats.repository;

import gr.qualco.demo.countrystats.entity.RegionArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionAreaRepository extends JpaRepository<RegionArea, String> {
}
