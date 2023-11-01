package drako.cars.persistence.mapper;

import drako.cars.domain.dto.CarPurchaseRequestDto;
import drako.cars.persistence.entity.CarPurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICarPurchaseMapper {

    @Mapping(source = "codeCar", target = "id.codeCar")
    @Mapping(target = "purchaseEntity", ignore = true)
    @Mapping(target = "carEntity", ignore = true)
    @Mapping(target = "id.purchaseNumberBill", ignore = true)
    CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto);
}
