package drako.cars.persistence.mapper;

import drako.cars.domain.pojo.CarBrandPojo;
import drako.cars.persistence.entity.CarBrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICarBrandMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandPojo toCarBrandPojo(CarBrandEntity brandEntity);

    @InheritInverseConfiguration
    CarBrandEntity toCarBrandEntity(CarBrandPojo brandPojo);

}
