package gr.qualco.demo.countrystats.configuration.mapper;

import gr.qualco.demo.countrystats.dto.language.LanguageDto;
import gr.qualco.demo.countrystats.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper extends BaseMapper<LanguageDto, Language> {

    @Override
    @Mapping(target = "id", ignore = true)
    LanguageDto toDto(Language entity);

    @Override
    List<LanguageDto> toDtoList(List<Language> entities);
}
