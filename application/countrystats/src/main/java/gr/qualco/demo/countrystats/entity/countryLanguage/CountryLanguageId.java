package gr.qualco.demo.countrystats.entity.countryLanguage;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguageId implements Serializable {

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "language_id")
    private Integer languageId;

}
