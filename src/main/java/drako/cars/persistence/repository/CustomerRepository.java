package drako.cars.persistence.repository;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.repository.ICustomerRepository;
import drako.cars.persistence.entity.CustomerEntity;
import drako.cars.persistence.mapper.ICustomerMapper;
import drako.cars.persistence.repository.crud.ICustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;

    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerCrudRepository.findById(cardId).map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email).map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        CustomerEntity customerEntity = iCustomerMapper.toCustomerEntity(customerDto);
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.save(customerEntity));
    }

    @Override
    public void delete(String cardId) {
        iCustomerCrudRepository.deleteById(cardId);
    }
}
