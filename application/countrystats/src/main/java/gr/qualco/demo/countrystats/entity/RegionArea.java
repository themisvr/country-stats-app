package gr.qualco.demo.countrystats.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "region_area")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionArea {

    @Id
    @Column(name = "region_name", length = 100)
    private String regionName;

    @Column(name = "region_area", precision = 15, scale = 2, nullable = false)
    private BigDecimal regionArea;
}
