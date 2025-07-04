package gr.qualco.demo.countrystats.entity.countryLanguage;

import gr.qualco.demo.countrystats.entity.Country;
import gr.qualco.demo.countrystats.entity.Language;
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

@Entity
@Table(name = "country_languages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(nullable = false)
    private boolean official;
}
