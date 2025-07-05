package gr.qualco.demo.countrystats.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "continents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "regions")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private Integer continentId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "continent", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Region> regions;
}
