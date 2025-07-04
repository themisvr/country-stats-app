package gr.qualco.demo.countrystats.entity.countryStat;

import gr.qualco.demo.countrystats.entity.Country;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "country_stats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryStat {

    @EmbeddedId
    private CountryStatId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryId")
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column
    private Integer population;

    @Column(precision = 15)
    private BigDecimal gdp;
}
