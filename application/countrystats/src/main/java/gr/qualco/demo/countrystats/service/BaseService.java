package gr.qualco.demo.countrystats.service;

import gr.qualco.demo.countrystats.configuration.mapper.BaseMapper;
import gr.qualco.demo.countrystats.dto.DtoInterface;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<TDto extends DtoInterface<ID>,
        TEntity,
        ID,
        TRepo extends JpaRepository<TEntity, ID>,
        TMapper extends BaseMapper<TDto, TEntity>> implements ServiceInterface<TDto, ID, TRepo> {

    @Getter
    protected final TRepo repository;
    protected final TMapper mapper;

    protected BaseService(TRepo repository, TMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TDto> findAllDto() {
        List<TEntity> entities = repository.findAll();
        return mapper.toDtoList(entities);
    }

    @Override
    public Optional<TDto> findByIdDto(ID id) {
        return repository.findById(id).map(mapper::toDto);
    }

    protected List<TEntity> findAllEntity() {
        return repository.findAll();
    }

}
