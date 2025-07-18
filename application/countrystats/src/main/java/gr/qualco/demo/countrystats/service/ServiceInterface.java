package gr.qualco.demo.countrystats.service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<TDto, ID, TRepo> {

    TRepo getRepository();

    List<TDto> findAllDto();

    Optional<TDto> findByIdDto(ID id);
}
