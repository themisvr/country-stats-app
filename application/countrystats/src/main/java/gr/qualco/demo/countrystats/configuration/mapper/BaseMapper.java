package gr.qualco.demo.countrystats.configuration.mapper;

import java.util.List;

public interface BaseMapper<Dto, Entity> {

    Dto toDto(Entity entity);

    List<Dto> toDtoList(List<Entity> entities);
}
