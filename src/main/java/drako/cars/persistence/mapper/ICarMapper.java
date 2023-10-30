package drako.cars.persistence.mapper;

import drako.cars.domain.dto.CarDto;
import drako.cars.persistence.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    CarDto toCarDto(CarEntity carEntity);

    @Mapping(target = "carBrandEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarsDtoList(List<CarEntity> carEntityList);
}
