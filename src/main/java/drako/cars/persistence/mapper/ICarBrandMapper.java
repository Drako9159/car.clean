package drako.cars.persistence.mapper;

import drako.cars.domain.dto.CarBrandDto;
import drako.cars.persistence.entity.CarBrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for transform objets CardBrand
 * Pojo to Entity
 * Entity to Pojo
 */
@Mapper(componentModel = "spring")
public interface ICarBrandMapper {

    /**
     * Convert entity to CarBrandPojo
     *
     * @param brandEntity entity to convert
     * @return pojo converted
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandDto toCarBrandDto(CarBrandEntity brandEntity);

    /**
     * Convert pojo to CarBrandEntity
     *
     * @param brandDto pojo to convert
     * @return entity converted
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntityList", ignore = true)
    CarBrandEntity toCarBrandEntity(CarBrandDto brandDto);

    /**
     * Get list of car brand transformed to pojo of list entities
     *
     * @param carBrandsEntity Entity for transform
     * @return list transformed
     */
    List<CarBrandDto> toCarBrandsDto(List<CarBrandEntity> carBrandsEntity);
}
