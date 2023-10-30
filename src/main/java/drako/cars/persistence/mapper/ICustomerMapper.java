package drako.cars.persistence.mapper;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for transform objets Customer
 * CustomerDto to CustomerEntity
 * Entity to Dto
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);

}
