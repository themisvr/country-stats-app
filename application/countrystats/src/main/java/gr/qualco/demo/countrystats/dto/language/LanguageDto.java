package gr.qualco.demo.countrystats.dto.language;

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
public class LanguageDto implements DtoInterface<Integer> {

    @JsonIgnore
    private Integer id;

    private String name;
}
