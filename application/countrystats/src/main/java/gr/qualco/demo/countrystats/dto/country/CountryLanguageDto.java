package gr.qualco.demo.countrystats.dto.country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.qualco.demo.countrystats.dto.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguageDto implements DtoInterface<Integer> {

    @JsonIgnore
    private Integer id;

    private String languageName;

    private boolean official;
}
