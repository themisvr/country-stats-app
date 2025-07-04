package gr.qualco.demo.countrystats.entity;

import gr.qualco.demo.countrystats.entity.countryLanguage.CountryLanguage;
import gr.qualco.demo.countrystats.entity.countryStat.CountryStat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "countries",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "country_code2"),
                @UniqueConstraint(columnNames = "country_code3")
        })
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal area;

    @Column(name = "national_day")
    private Date nationalDay;

    @Column(nullable = false, name = "country_code2", length = 2)
    private String countryCode2;

    @Column(nullable = false, name = "country_code3", length = 3)
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<CountryLanguage> countryLanguages;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<CountryStat> countryStats;
}
